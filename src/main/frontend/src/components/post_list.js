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


    handleClick(id) {
        this.props.history.push(`/post/${id}`);
    }

    renderPosts() {
        return this.state.posts.map((post => {
            let isAuthor = false;
            if (User.isAuthenticated && User.id == post.author.id) {
                isAuthor = true;
            }

            let date = new Date(post.createdAt).toDateString();

            return (
                <tr key={post.id} onClick={() => this.handleClick(post.id)} className={isAuthor ? 'success' : ''}>
                    <td>{date}</td>
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