var Greeter = React.createClass({
    render: function () {
        return <h1>Hello, {this.props.message}!</h1>
    }
});


ReactDOM.render(
    <div>
        <Greeter message="Students"/>
        <Greeter message="Michael"/>
    </div>,
    document.getElementById('root'));

