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
                    <div className="menu">
                        <Link to="/">Post list</Link>
                        <Link to="/post/new">Create post</Link>
                        <Link to="/user/login">Login</Link>
                    </div>
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

