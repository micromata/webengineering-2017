import axios from "axios";
import React from "react";
import {Link} from "react-router-dom";

class PostList extends React.Component {
    constructor(props) {
        super();
        this.state = {
            posts: []
        }
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


    renderPosts() {
        return this.state.posts.map((post => {
            return (
                <Link to={`/post/${post.id}`} key={post.id}>
                    <li>
                        {post.id} {post.title} {post.author.email} <span
                        onClick={() => this.deletePost(post.id)}>DELETE</span>
                    </li>
                </Link>
            );
        }));
    }


    render() {
        return (
            <div className="component">
                <h1>Posts</h1>
                <ul>
                    {this.renderPosts()}
                </ul>
            </div>
        );
    }
}


export default PostList;