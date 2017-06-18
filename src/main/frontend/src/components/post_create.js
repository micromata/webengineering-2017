import React from "react";

// See https://facebook.github.io/react/docs/forms.html for documentation about forms.
class PostCreate extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: 'default title'
        };
    }


    render() {
        return (
            <div>
                <form>
                    <label>
                        title
                        <input type="text" name="title" value={this.state.title}/>
                    </label>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        );
    }
}

export default PostCreate;