package com.chat.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /* this interface which is implemented is used to define methods for configuring message handling
    protocols like(STOMP) from the web socket clients */
    //STOMP is used for message handling like organizing and routing

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")           // backend endpoint http://localhost:8080/chat
                .setAllowedOrigins("http://localhost:8080")   //frontend request url for security purpose 8080 IS USED DUE TO THYMELEAF
                .withSockJS();                      //makes app accessible even for without websocket
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //set message broker
        registry.enableSimpleBroker("/topics");      //   /topics/chatroom1 whomever registered with that subscription will get message
        //expect message with /app/sendmessage
        registry.setApplicationDestinationPrefixes("/app");    //process message
    }
}
