import axios from "axios";
import React from "react";
import User from "../util/User";

class PostList extends React.Component {
    constructor(props) {
        super();
        this.state = {
            posts: []
        }

        this.handleClick = this.handleClick.bind(this);
    }

    // This function is called before render() to initialize its state.
    componentWillMount() {
        axios.get('/api/post')
            .then(({data}) => {
                this.setState({
                    posts: data
                })
            });
    }


    deletePost(id) {
        // ES6 string interpolation (https://developer.mozilla.org/de/docs/Web/JavaScript/Reference/template_strings)
        // No error handling for now, e.g. if the user is not authenticated.
        axios.delete(`/api/post/${id}`)
            .then((data) => {
                // Remove post from list of posts.
                const posts = this.state.posts.filter(e => e.id != id);
                this.setState({
                    posts: posts
                })
            });
    }

    handleClick(id) {
        this.props.history.push(`/post/${id}`);
    }

    renderPosts() {
        return this.state.posts.map((post => {
            let isAuthor = false;
            if (User.isAuthenticated && User.id == post.author.id) {
                isAuthor = true;
            }

            return (
                <tr key={post.id} onClick={() => this.handleClick(post.id)} className={isAuthor ? 'success' : ''}>
                    <td>{post.createdAt}</td>
                    <td>{post.title} </td>
                    <td>{post.author.email}</td>
                </tr>
            );
        }));
    }


    render() {
        return (
            <div className="component">
                <table className="table table-hover">
                    <thead>
                    <tr>
                        <th className="col-sm-2">Created at</th>
                        <th className="col-sm-8">Title</th>
                        <th className="col-sm-2">Author</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.renderPosts()}
                    </tbody>
                </table>
            </div>
        );
    }
}


export default PostList;