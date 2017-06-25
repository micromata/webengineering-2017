import React from "react";
import ReactDOM from "react-dom";
import Authentication from "./components/authentication";

import PostCreate from "./components/post_create";
import PostList from "./components/post_list";


ReactDOM.render(
    <div>
        <PostList />
        <PostCreate/>
        <Authentication />
    </div>,
    document.getElementById('root'));

