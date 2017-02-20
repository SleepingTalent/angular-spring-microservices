package com.noveria.counter;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.logging.Logger;

@Component
public class CounterHandler extends TextWebSocketHandler {

    protected Logger logger = Logger.getLogger(getClass().getName());

    WebSocketSession session;

    // This will send only to one client(most recently connected)
    public void counterIncrementedCallback(int counter) {
        logger.info("Trying to send Websocket Data :" + counter);
        if (session != null && session.isOpen()) {
            try {
                logger.info("Now sending Websocket Data :" + counter);
                session.sendMessage(new TextMessage("{\"value\": \"" + counter + "\"}"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.info("Don't have open session to send Websocket Data :" + counter);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        logger.info("Connection established");
        this.session = session;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        if ("CLOSE".equalsIgnoreCase(message.getPayload())) {
            session.close();
        } else {
            logger.info("Received:" + message.getPayload());
        }
    }
}
