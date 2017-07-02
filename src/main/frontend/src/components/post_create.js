import axios from "axios";
import React from "react";

import {translate} from "react-i18next";

// See https://facebook.github.io/react/docs/forms.html for documentation about forms.
class PostCreate extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: '',
            comment: ''
        };

        this.handleTitleChange = this.handleTitleChange.bind(this);
        this.handleCommentChange = this.handleCommentChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    handleTitleChange(event) {
        this.setState({title: event.target.value});
    }

    handleCommentChange(event) {
        this.setState({comment: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();
        let comments = [];
        if (this.state.comment) {
            comments = [{text: this.state.comment}];
        }
        axios.post('/api/post',
            {
                title: this.state.title,
                comments: comments
            })
            .then((data) => {
                // Redirect to front page.
                this.props.history.push("/");
            });
    }


    render() {
        const {t} = this.props;

        return (
            <div className="component">
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label>
                            Title
                        </label>
                        <input type="text" name="title" className="form-control"
                               autoFocus={true}
                               value={this.state.title}
                               onChange={this.handleTitleChange}/>
                    </div>
                    <div className="form-group">
                        <label>
                            Optional initial comment
                        </label>
                        <textarea className="form-control"
                                  value={this.state.comment}
                                  onChange={this.handleCommentChange}/>
                    </div>

                    <input type="submit" className="btn btn-success" value="Submit"/>
                </form>
            </div>
        );
    }
}

export default translate()(PostCreate);