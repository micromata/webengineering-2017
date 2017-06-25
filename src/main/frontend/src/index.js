import React from "react";
import {CookiesProvider} from "react-cookie";
import ReactDOM from "react-dom";
import {HashRouter as Router, Route, Switch} from "react-router-dom";


import Authentication from "./components/authentication";
import PostCreate from "./components/post_create";
import PostList from "./components/post_list";


ReactDOM.render(
    <CookiesProvider>
        <div>
            <Router>
                <Switch>
                    {/*Authentication*/}
                    <Route path="/user/login" component={Authentication}/>

                    {/*Post handling*/}
                    <Route path="/post/new" component={PostCreate}/>

                    {/*Default route*/}
                    <Route path="/" component={PostList}/>
                </Switch>
            </Router>
        </div>
    </CookiesProvider>,
    document.getElementById('root'));

