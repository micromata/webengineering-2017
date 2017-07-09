package com.micromata.webengineering.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Main entry point and configuration base of the application.
 */
@Configuration
@EnableWebSocket
@SpringBootApplication
public class Main implements WebSocketConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // http://localhost:8080/message
        registry.addHandler(new MessageHandler(), "/message");
    }
}
