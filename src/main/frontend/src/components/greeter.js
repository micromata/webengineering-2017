import React from "react";

class Greeter extends React.Component {
    render() {
        const message = !this.props.message ? 'unknown' : this.props.message;
        return <h1>Hello, {message}!</h1>
    }
}

export default Greeter;