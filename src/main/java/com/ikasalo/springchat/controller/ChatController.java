package com.ikasalo.springchat.controller;

import com.ikasalo.springchat.model.ChatMessage;
import com.ikasalo.springchat.model.Obavijest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * Sve kaj pocinje sa app ce doc ovjde
 */
@Controller
public class ChatController {

   /* @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage message) {
        return message;
    }

    public ChatMessage addUser(@Payload ChatMessage message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }*/

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Obavijest sendMessage(@Payload Obavijest message) {
        return message;
    }

    public Obavijest addUser(@Payload Obavijest message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getRadnik());
        return message;
    }

}
