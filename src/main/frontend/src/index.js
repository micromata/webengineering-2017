import React from "react";
import ReactDOM from "react-dom";

class Greeter extends React.Component {
    render() {
        return <h1>Hello, {this.props.message}!</h1>
    }
}

ReactDOM.render(
    <div>
        <Greeter message="Students"/>
        <Greeter message="Michael"/>
    </div>,
    document.getElementById('root'));

