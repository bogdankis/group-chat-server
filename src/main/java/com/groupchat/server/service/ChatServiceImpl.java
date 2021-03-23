package com.groupchat.server.service;

import com.groupchat.server.dto.CreateMessageRequest;
import com.groupchat.server.dto.MessageResponse;
import com.groupchat.server.model.Profile;
import com.groupchat.server.repo.ChatRepo;
import com.groupchat.server.repo.ProfileRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatRepo chatRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    ConnectionScheduler connectionScheduler;

    @Autowired
    ParentServerTemplate parentServerTemplate;

    public List<MessageResponse> sendMessage(@RequestBody CreateMessageRequest createMessageRequest) throws NotFoundException {
        //TODO Anunta connectionScheduler de event.
        //TODO Adauga obiectului createMessageRequest senderId-ul (id-ul profilului tau)
        //TODO trimite request la server-ul parinte cu mesajul.;
        connectionScheduler.updateLastEvent();
        createMessageRequest.setSenderId(String.valueOf(profileRepo.getProfile()));
        return parentServerTemplate.sendMessage(createMessageRequest);


    }

    public List<MessageResponse> getMessages() {
        //TODO Anunta connectionScheduler de event.
        //TODO Ia mesajele de la server-ul parinte
        connectionScheduler.updateLastEvent();
        return parentServerTemplate.getMessages();
    }
}
