import axios from "axios";
import React from "react";

import User from "../util/User";

class PostDetail extends React.Component {
    constructor(props) {
        super();
        this.state = {
            post: undefined,
            comment: ''
        }

        this.handleCommentSubmit = this.handleCommentSubmit.bind(this);
        this.handleCommentChange = this.handleCommentChange.bind(this);
    }

    componentWillMount() {
        axios.get(`/api/post/${this.props.match.params.id}`)
            .then(({data}) => {
                this.setState({
                    post: data
                });
            });
    }

    handleCommentChange(event) {
        this.setState({comment: event.target.value});
    }

    handleCommentSubmit(event) {
        event.preventDefault();
        axios.post(`/api/post/${this.props.match.params.id}/comment`,
            {
                text: this.state.comment
            })
            .then((data) => {
                // Update state to show comment by retrieving state from server.
                // Alternatively we could also simply add the comment to our state to prevent a
                // call to the backend.
                this.setState({comment: ''});
                this.componentWillMount();
            });
    }

    renderComments(post) {
        return post.comments.map((comment => {
            return (
                <div key={comment.id}>
                    <hr/>
                    <div>Author {comment.author.email}</div>
                    <div>Created at {new Date(comment.createdAt).toISOString()}</div>
                    {comment.text}
                </div>
            );
        }));
    }

    render() {
        const post = this.state.post;
        if (!post) {
            // Do not show anything while loading.
            return <div></div>;
        }

        return (
            <div>
                {/*A row in a bootstrap context must be stored in a container*/}
                <div className="container-fluid post-detail">
                    <span className="col-sm-8 post-title">{post.title}</span>
                    <span>{post.author.email}</span>
                    <span>{new Date(post.createdAt).toDateString()}</span>
                </div>

                {this.renderComments(post)}
                <hr/>
                { User.isAuthenticated() &&
                <form onSubmit={this.handleCommentSubmit}>
                    <label>
                        Comment
                        <textarea name="comment" value={this.state.comment} onChange={this.handleCommentChange}/>
                    </label>
                    <input type="submit" value="Submit"/>
                </form>
                }
            </div>
        );
    }
}

export default PostDetail;