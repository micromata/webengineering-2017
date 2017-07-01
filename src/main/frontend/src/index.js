import React from "react";
import {CookiesProvider} from "react-cookie";
import ReactDOM from "react-dom";

import {I18nextProvider} from "react-i18next";
import {HashRouter as Router, Link, Route, Switch} from "react-router-dom";

import Authentication from "./components/authentication";
import PostCreate from "./components/post_create";
import PostDetail from "./components/post_detail";
import PostList from "./components/post_list";
import i18n from "./i18n";
import User from "./util/User";

// Force initialization of the object.
User.isAuthenticated();

ReactDOM.render(
    <CookiesProvider>
        <I18nextProvider i18n={i18n}>
            <Router>
                <div>
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
                                    <li><Link to="/user/login">Login</Link></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                    <Switch>
                        {/*Authentication*/}
                        <Route path="/user/login" component={Authentication}/>

                        {/*Post handling*/}
                        <Route path="/post/new" component={PostCreate}/>
                        <Route path="/post/:id" component={PostDetail}/>

                        {/*Default route*/}
                        <Route path="/" component={PostList}/>
                    </Switch>
                </div>
            </Router>
        </I18nextProvider>
    </CookiesProvider>,
    document.getElementById('root'));

