package com.groupchat.server.service;

import com.groupchat.server.dto.CreateMessageRequest;
import com.groupchat.server.dto.CreateProfileRequest;
import com.groupchat.server.dto.MessageResponse;
import com.groupchat.server.model.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;
import java.util.List;

@Service
public class ParentServerTemplateImpl implements ParentServerTemplate {

    String BASE_URL = "https://group-chat-parent-server.herokuapp.com/api/";
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Profile> getProfiles() {

         restTemplate.getForObject("/api/profile", String.class);
        //TODO Cheama endpoint-ul din serverul parinte pentru a luat toate profilele.
        return null;
    }

    @Override
    public Profile createProfile(CreateProfileRequest createProfileRequest) {
        restTemplate.getForObject("/api/profile", String.class);
        //TODO Cheama endpoint-ul din serverul parinte pentru a crea profilul.
        return null;
    }

    @Override
    public void connect(String id) {
        //TODO Cheama endpoint-ul din serverul parinte pentru a te conecta.
        restTemplate.getForObject("/api/connection/connect/{id}", String.class);


    }

    @Override
    public void disconnect(String id) {
        //TODO Cheama endpoint-ul din serverul parinte pentru a te deconecta.
        restTemplate.getForObject("/api/connection/disconnect/{id}", String.class);

    }

    @Override
    public List<MessageResponse> getMessages() {
        restTemplate.getForObject("/api/chat/", String.class);
        //TODO Cheama endpoint-ul din serverul parinte pentru a lua toate mesajele.
        return null;
    }

    @Override
    public List<MessageResponse> sendMessage(CreateMessageRequest createMessageRequest) {
        restTemplate.getForObject("/api/chat/", String.class);
        //TODO Cheama endpoint-ul din serverul parinte pentru a lua crea un mesaj.
        return null;
    }
}
