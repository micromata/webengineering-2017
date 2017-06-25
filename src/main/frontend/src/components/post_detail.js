import React from "react";

class PostDetail extends React.Component {
    render() {
        return (
            <div className="component">
                <h1>Post Detail</h1>
                {this.props.match.params.id}
            </div>
        );
    }
}

export default PostDetail;