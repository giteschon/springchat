package com.ikasalo.springchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //tu se klijenti spajaju
        //enable SockJs je za one koji nemaju browser support za ws
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //poruke koje pocinju sa app ce se slati na message handling controller
        registry.setApplicationDestinationPrefixes("/app");
//topic one to many, queue -> one to one (single chat)
        registry.enableSimpleBroker("/topic");
    }
}
