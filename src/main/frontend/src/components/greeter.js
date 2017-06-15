import React from "react";
import Counter from "./counter";

// class Greeter extends React.Component {
//     render() {
//         const message = !this.props.message ? 'unknown' : this.props.message;
//         return <h1>Hello, {message}! (<Counter />)</h1>
//     }
// }


const Greeter = (props) => {
    const message = !props.message ? 'unknown' : props.message;
    return <h1>Hello (functional component), {message}! (<Counter />)</h1>
};

export default Greeter;