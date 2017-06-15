import axios from "axios";
import React from "react";
import ReactDOM from "react-dom";

import Greeter from "./components/greeter";


// Let' write some axios test code and check that everything works with console.log. This is
// comfortable and we do not need to modify our react code to check that we have understood how
// axios works.

axios.get('http://www.mlesniak.com')
    .then(function (data) {
        console.log(data.data);
    });

ReactDOM.render(
    <div>
        <Greeter message="Students"/>
        <Greeter message="Michael"/>
        <Greeter />
    </div>,
    document.getElementById('root'));

