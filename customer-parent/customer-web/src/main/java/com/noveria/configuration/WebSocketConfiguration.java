package com.noveria.configuration;

import com.noveria.counter.CounterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.util.logging.Logger;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    protected Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    CounterHandler counterHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        logger.info("Registering WebSocket at path : /counter");
        registry.addHandler(counterHandler, "/counter");
    }
}
