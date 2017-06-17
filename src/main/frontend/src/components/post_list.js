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
                    title: 'test -- loading will be implemented later'
                }
            ]
        });
    }


    render() {
        return (
            <div>
                <h1>Posts</h1>
                {this.state.posts}
            </div>
        );
    }
}


export default PostList;