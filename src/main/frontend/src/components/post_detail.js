import axios from "axios";
import React from "react";
import {Button, Modal} from "react-bootstrap";

import User from "../util/User";

class PostDetail extends React.Component {
    constructor(props) {
        super();
        this.state = {
            post: undefined,
            comment: '',
            askDelete: false
        }

        this.handleCommentSubmit = this.handleCommentSubmit.bind(this);
        this.handleCommentChange = this.handleCommentChange.bind(this);
        this.askDelete = this.askDelete.bind(this);
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

        if (this.state.comment.trim() === "") {
            return;
        }

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

    deletePost(id) {
        axios.delete(`/api/post/${id}`)
            .then((data) => {
                this.props.history.push("/");
            });
    }

    askDelete() {
        this.setState({askDelete: true});
    }

    renderComments(post) {
        return post.comments.map((comment => {
            return (
                <tr key={comment.id}>
                    <td className="col-sm-1">{new Date(comment.createdAt).toDateString()}</td>
                    <td className="col-sm-1">{comment.author.email}</td>
                    <td className="col-sm-10">{comment.text}</td>
                </tr>
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

                <div>
                    {/*A row in a bootstrap context must be stored in a container*/}
                    <div className="container-fluid post-detail">
                        <div>
                            <span className="post-title">{post.title}</span>
                            <div className="pull-right delete-button">
                                { User.isAuthenticated() && User.id === post.author.id &&
                                <button
                                    onClick={() => this.askDelete()}
                                    className="btn btn-danger">Delete</button>
                                }
                            </div>
                        </div>
                        <div className="post-subtitle">
                            <span>{post.author.email}</span>
                            <span>@</span>
                            <span>{new Date(post.createdAt).toDateString()}</span>
                        </div>

                    </div>

                    <table className="table table-striped">
                        <tbody>
                        {this.renderComments(post)}
                        </tbody>
                    </table>
                    <hr/>

                    { User.isAuthenticated() &&
                    <form onSubmit={this.handleCommentSubmit}>
                        <div className="form-group">
                        <textarea
                            autoFocus={true}
                            placeholder="Your comment..."
                            className="form-control"
                            name="comment"
                            value={this.state.comment}
                            onChange={this.handleCommentChange}/>
                        </div>
                        <input type="submit" value="Submit" className="btn btn-success"/>
                    </form>
                    }

                    { this.state.askDelete &&
                    <Modal.Dialog>
                        <Modal.Header>
                            <Modal.Title>Are you sure?</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            Do you want to delete your post?
                        </Modal.Body>
                        <Modal.Footer>
                            <Button onClick={() => {
                                this.setState({askDelete: false})
                            }
                            }>Cancel</Button>
                            <Button
                                onClick={() => {
                                    this.deletePost(this.state.post.id)
                                }}
                                bsStyle="primary">Delete</Button>
                        </Modal.Footer>
                    </Modal.Dialog>
                    }
                </div>
            </div>
        );
    }
}

export default PostDetail;