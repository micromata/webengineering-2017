import React from "react";
import {Link} from "react-router-dom";
import User from "../util/User";

class Navigation extends React.Component {
    render() {
        return (
            <nav className="navbar navbar-inverse navbar-fixed-top">
                <div className="container">
                    <div className="navbar-header">
                        <button type="button" className="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#navbar">
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                        </button>
                        <Link to="/" className="navbar-brand">Demo</Link>
                    </div>
                    <div id="navbar" className="collapse navbar-collapse">
                        <ul className="nav navbar-nav">
                            <li><Link to="/">Post list</Link></li>
                            <li><Link to="/post/new">Create post</Link></li>

                            { User.isNotAuthenticated() &&
                            <li><Link to="/user/login">Login</Link></li>
                            }
                            {
                                User.isAuthenticated() &&
                                <li><Link to="/user/login">Preferences</Link></li>
                            }
                        </ul>
                    </div>
                </div>
            </nav>
        );
    }
}

export default Navigation;