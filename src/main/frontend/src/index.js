import axios from "axios";
import React from "react";

// Create a new post with a random title.
axios.post('/api/post',
    {
        // POST data
        title: 'axios-' + new Date().getTime()
    }, {
        // Configuration
        headers: {
            Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJrYWkiLCJqdGkiOiIyIn0.h3ezvhsje3tpvHbXxz7TUmy7KhT5yjtljXKvDeo8MM2RTAEIP6l2vdRHw2KKg0-HgK-8CsMY5im3kp6zIogUTQ'
        }
    });

// Retrieve list of posts and show them.
axios.get('/api/post')
    .then(({data}) => {
        for (var post of data) {
            console.log(post);
        }
    });


// This annoys me while looking at the browser ;-)
//
// ReactDOM.render(
//     <div>
//         <Greeter message="Students"/>
//         <Greeter message="Michael"/>
//         <Greeter />
//     </div>,
//     document.getElementById('root'));

