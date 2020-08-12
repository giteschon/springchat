package com.ikasalo.springchat.controller;

import com.ikasalo.springchat.model.ChatMessage;
import com.ikasalo.springchat.model.Obavijest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
public class WebSocketEventListener {

    @Autowired
    private SimpMessageSendingOperations operations;

    @EventListener
    public void connect(SessionConnectedEvent event) {

        log.info("Connected {}, user: {}", event.getSource(), event.getUser().getName());
    }

    @EventListener
    public void disconnect(SessionDisconnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) accessor.getSessionAttributes().get("username");
        if (username != null) {
            log.info("Disconnected");

          /*  ChatMessage message = new ChatMessage();
            message.setType(ChatMessage.MessageType.LEAVE);
            message.setSender(username);*/

            Obavijest message= new Obavijest();
            message.setOpis(ChatMessage.MessageType.LEAVE.name());


            operations.convertAndSend("/topic/public", message);
        }

    }
}
