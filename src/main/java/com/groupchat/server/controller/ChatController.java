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
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    ChatService chatService;

    @PostMapping()
    public ResponseEntity<?> sendMessage(@RequestBody CreateMessageRequest createMessageRequest) {
        try {
            return ResponseEntity.ok(chatService.sendMessage(createMessageRequest));  //TODO trimite mesaj
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mesaj necreat");
        }
    }

    @GetMapping()
    public ResponseEntity<?> getMessages() {
        return ResponseEntity.ok(chatService.getMessages());  //TODO intoarce toate mesajele
    }

}
