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
        this.setState({
            posts: [
                {
                    title: 'test -- loading will be implemented later',
                    id: 1
                }
            ]
        });
    }

    renderPosts() {
        return this.state.posts.map((post => {
            return (
                <li key={post.id}>
                    {post.title}
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