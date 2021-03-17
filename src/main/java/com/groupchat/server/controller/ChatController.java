package com.groupchat.server.controller;

import com.groupchat.server.dto.CreateMessageRequest;
import com.groupchat.server.service.ChatService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// TODO Mapeaza controller-ul la /api/chat
public class ChatController {

    @Autowired
    ChatService chatService;

    // TODO Mapeaza metoda la POST, cu path-ul /
    @PostMapping("/api/chat/")
    public ResponseEntity<?> sendMessage(@RequestBody CreateMessageRequest createMessageRequest) {
        //TODO
        try {
            return ResponseEntity.ok(chatService.sendMessage(createMessageRequest));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mesaj necreat");
        }
    }


    // TODO Mapeaza metoda la GET, cu path-ul /
    @GetMapping("/api/chat/")
    public ResponseEntity<?> getMessages() {
        //TODO
        return ResponseEntity.ok(chatService.getMessages());
    }

}
