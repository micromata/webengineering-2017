import axios from "axios";
import React from "react";

// Create a new post with a random title.
axios.post('/api/post', {
    title: 'axios-' + new Date().getTime()
});

// Retrieve list of posts and show them.
// axios.get('/api/post')
//     .then(({data}) => {
//         for (var post of data) {
//             console.log(post);
//         }
//     });


// This annoys me while looking at the browser ;-)
//
// ReactDOM.render(
//     <div>
//         <Greeter message="Students"/>
//         <Greeter message="Michael"/>
//         <Greeter />
//     </div>,
//     document.getElementById('root'));

