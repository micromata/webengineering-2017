import React from "react";
import {CookiesProvider} from "react-cookie";
import ReactDOM from "react-dom";
import {HashRouter as Router, Link, Route, Switch} from "react-router-dom";


import Authentication from "./components/authentication";
import PostCreate from "./components/post_create";
import PostList from "./components/post_list";


ReactDOM.render(
    <CookiesProvider>
        <Router>
            <div>
                <div className="menu">
                    <Link to="/post/new">Create post</Link>
                    <Link to="/">Post list</Link>
                    <Link to="/user/login">Login</Link>
                </div>
                <Switch>
                    {/*Authentication*/}
                    <Route path="/user/login" component={Authentication}/>

                    {/*Post handling*/}
                    <Route path="/post/new" component={PostCreate}/>

                    {/*Default route*/}
                    <Route path="/" component={PostList}/>
                </Switch>
            </div>
        </Router>
    </CookiesProvider>,
    document.getElementById('root'));

