import React from "react";
import Counter from "./counter";

// class Greeter extends React.Component {
//     render() {
//         const message = !this.props.message ? 'unknown' : this.props.message;
//         return <h1>Hello, {message}! (<Counter />)</h1>
//     }
// }


const Greeter = ({message}) => {
    const procMessage = !message ? 'unknown' : message;
    return (
        <Counter>
            <h1>Hello, {procMessage}!</h1>
        </Counter>);
};

export default Greeter;