import axios from "axios";
import React from "react";

import {translate} from "react-i18next";

// See https://facebook.github.io/react/docs/forms.html for documentation about forms.
class PostCreate extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: ''
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
                <h1>Post create</h1>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        title
                        <input type="text" name="title" value={this.state.title} onChange={this.handleTitleChange}/>
                    </label>
                    <input type="submit" value="Submit"/>
                </form>

                <hr/>
                Name: {t('applicationName')}
            </div>
        );
    }
}

export default translate()(PostCreate);