import axios from "axios";
import React from "react";
import {withCookies} from "react-cookie";

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
        // Syntactic ES6 sugar for
        //
        //   cookies.get = this.props.get
        //   cookies.set = this.props.set
        //   ..
        //
        const {cookies} = this.props;

        event.preventDefault();
        axios.post('/user/login', this.state)
            .then(({data}) => {
                axios.defaults.headers.common['Authorization'] = `Bearer ${data.token}`;
                User.email = data.user.email;
                User.id = data.user.id;

                // Store authentication values even after refresh.
                cookies.set('auth', {
                    token: data.token,
                    user: User
                }, {path: '/'});

                // Since we do not have the User as part of the component's state,
                // calling this.SetState() makes no sense. Instead we have to manually
                // force the component to update.
                this.forceUpdate();
            });
    }


    render() {
        return (
            <div className="component">
                <h1>Authentication</h1>
                Current user: {User.email || 'not logged in'}
                <p/>
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


export default withCookies(Authentication);