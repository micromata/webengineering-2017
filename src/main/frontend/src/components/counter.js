import React from "react";

// A general counter component.
class Counter extends React.Component {
    constructor(props) {
        super();
        this.state = {
            counter: 0
        }
    }

    onClick() {
        this.setState({
            counter: this.state.counter + 1
        });
    }

    render() {
        return (
            <div onClick={this.onClick.bind(this)}>
                {this.props.children}
                ({this.state.counter})
            </div>)
    }
}


export default Counter;