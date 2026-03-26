package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import com.chat.app.repository.ChatRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;
    private final ChatRepository chatRepository;

    public ChatController(SimpMessagingTemplate messagingTemplate,
                          ChatRepository chatRepository) {
        this.messagingTemplate = messagingTemplate;
        this.chatRepository = chatRepository;
    }

    /*handles incoming message and add the message/broadcast messages(MessageMapping annotation)
     to the chat (SendTo annotation)
     */
//    @MessageMapping("/sendMessage")
//    @SendTo("/topics/messages")
//   public  ChatMessage sendMessage( ChatMessage chatMessage){
//       return chatMessage;
//   }
    @MessageMapping("/sendMessage")
 @SendTo("/topics/messages")
    public void sendMessage(ChatMessage chatMessage){

        System.out.println("Received: " + chatMessage.getContent());
        ChatMessage saved = chatRepository.save(chatMessage); // save to DB
        System.out.println("Sending to topic...");
        messagingTemplate.convertAndSend("/topics/messages", saved); //send to UI
    }


    //thymeLeaf template
    @GetMapping("chat")
    public String chat(){
        return "chat";
    }
}
