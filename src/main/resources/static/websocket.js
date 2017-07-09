// Websocket example.
// Since we are using no babel, etc... no ES6 features can be used.

// See https://de.wikipedia.org/wiki/WebSocket

var url = "ws://localhost:8080/message";
var socket = new WebSocket(url);

socket.onopen = function () {
    console.log("Connection established...");
};


socket.onmessage = function (messageEvent) {
    console.log("> " + messageEvent.data);

    var output = document.getElementById('output');
    var div = document.createElement("div");
    div.className = "message";
    div.innerHTML = messageEvent.data;

    output.appendChild(div);
};

socket.onerror = function (errorEvent) {
    console.log("Error. Connection closed.");
};

socket.onclose = function (closeEvent) {
    console.log('Connection closed. Code: ' + closeEvent.code + '; Reason: ' + closeEvent.reason);
};

send = function (msg) {
    socket.send(msg);
}


function sendMessage(event) {
    event.preventDefault();
    let element = document.getElementById("form").elements["message"];
    var message = element.value;
    element.value = '';
    send(message);
}