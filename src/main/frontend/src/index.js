import React from "react";
import {CookiesProvider} from "react-cookie";
import ReactDOM from "react-dom";

import Authentication from "./components/authentication";
import PostCreate from "./components/post_create";
import PostList from "./components/post_list";


ReactDOM.render(
    // This component will insert a property cookies to each child.
    <CookiesProvider>
        <div>
            <PostList />
            <PostCreate/>
            <Authentication />
        </div>
    </CookiesProvider>,
    document.getElementById('root'));

