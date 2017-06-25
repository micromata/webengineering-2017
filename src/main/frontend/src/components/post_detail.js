import axios from "axios";
import React from "react";

class PostDetail extends React.Component {
    constructor(props) {
        super();
        this.state = {
            post: undefined
        }
    }

    componentWillMount() {
        axios.get(`/api/post/${this.props.match.params.id}`)
            .then(({data}) => {
                this.setState({
                    post: data
                });
            });
    }


    render() {
        const post = this.state.post;
        if (!post) {
            // Do not show anything while loading.
            return <div></div>;
        }

        console.log(post);

        return (
            <div className="component">
                <h1>Post Detail</h1>
                <div>Title {post.title}</div>
                <div>Author {post.author.email}</div>
                <div>Created at {new Date(post.createdAt).toISOString()}</div>
            </div>
        );
    }
}

export default PostDetail;