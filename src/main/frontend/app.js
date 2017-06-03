var Greeter = React.createClass({
    render: function () {
        return <h1>Hello, {this.props.message}!</h1>
    }
});


ReactDOM.render(
    <Greeter message="Students"/>,
    document.getElementById('root'));

