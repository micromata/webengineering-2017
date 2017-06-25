import axios from "axios";
import React from "react";
import ReactDOM from "react-dom";
import Authentication from "./components/authentication";

import PostCreate from "./components/post_create";
import PostList from "./components/post_list";

// Set authorization header globally for all requests.
// See https://github.com/mzabriskie/axios#global-axios-defaults
//
axios.defaults.headers.common['Authorization'] = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJrYWkiLCJqdGkiOiIyIn0.h3ezvhsje3tpvHbXxz7TUmy7KhT5yjtljXKvDeo8MM2RTAEIP6l2vdRHw2KKg0-HgK-8CsMY5im3kp6zIogUTQ';


ReactDOM.render(
    <div>
        <PostList />
        <PostCreate/>
        <Authentication />
    </div>,
    document.getElementById('root'));

