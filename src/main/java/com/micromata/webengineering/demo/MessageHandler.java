package com.micromata.webengineering.demo;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageHandler extends TextWebSocketHandler {
    private ConcurrentLinkedQueue<WebSocketSession> clients;

    public MessageHandler() {
        clients = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Simulate delay...
        Thread.sleep(3000);
        TextMessage msg = new TextMessage("Hello, " + message.getPayload() + "!");
        session.sendMessage(msg);

        Iterator<WebSocketSession> it = clients.iterator();
        while (it.hasNext()) {
            WebSocketSession chatPartner = it.next();
            if (chatPartner.equals(session)) {
                // Do not send messages to yourself.
                continue;
            }

            chatPartner.sendMessage(message);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        clients.add(session);

        TextMessage msg = new TextMessage("Hello!");
        session.sendMessage(msg);
    }
}
