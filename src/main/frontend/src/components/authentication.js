import axios from "axios";
import React from "react";
import User from "../util/User";

class Authentication extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: ''
        };

        this.handleEmailChange = this.handleEmailChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    handleEmailChange(event) {
        this.setState({email: event.target.value});
    }


    handlePasswordChange(event) {
        this.setState({password: event.target.value});
    }


    handleSubmit(event) {
        event.preventDefault();
        axios.post('/user/login', this.state)
            .then(({data}) => {
                console.log(data);
                axios.defaults.headers.common['Authorization'] = `Bearer ${data.token}`;
                User.email = data.user.email;
                User.id = data.user.id;
                console.log(User);
            });
    }

    render() {
        return (
            <div className="component">
                <h1>Authentication</h1>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Email
                        <input type="text" name="email" value={this.state.email} onChange={this.handleEmailChange}/>
                    </label>
                    <label>
                        Password
                        <input type="password" name="password" value={this.state.password}
                               onChange={this.handlePasswordChange}/>
                    </label>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        );
    }
}


export default Authentication;