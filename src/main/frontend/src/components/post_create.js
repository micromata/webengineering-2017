import axios from "axios";
import React from "react";

// See https://facebook.github.io/react/docs/forms.html for documentation about forms.
class PostCreate extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: 'default title'
        };

        this.handleTitleChange = this.handleTitleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    handleTitleChange(event) {
        this.setState({title: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();
        axios.post('/api/post',
            {
                title: this.state.title
            });
    }


    render() {
        return (
            <div className="component">
                <h1>Post create</h1>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        title
                        <input type="text" name="title" value={this.state.title} onChange={this.handleTitleChange}/>
                    </label>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        );
    }
}

export default PostCreate;