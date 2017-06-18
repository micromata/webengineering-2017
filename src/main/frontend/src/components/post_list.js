import axios from "axios";
import React from "react";

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
        console.log("Deleting post " + id);
    }

    renderPosts() {
        return this.state.posts.map((post => {
            return (
                <li key={post.id}>
                    {post.id} {post.title} <span onClick={() => this.deletePost(post.id)}>DELETE</span>
                </li>
            );
        }));
    }


    render() {
        return (
            <div>
                <h1>Posts</h1>
                <ul>
                    {this.renderPosts()}
                </ul>
            </div>
        );
    }
}


export default PostList;