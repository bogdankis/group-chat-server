package com.groupchat.server.service;

import com.groupchat.server.dto.CreateMessageRequest;
import com.groupchat.server.dto.CreateProfileRequest;
import com.groupchat.server.dto.MessageResponse;
import com.groupchat.server.model.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.List;

@Service
public class ParentServerTemplateImpl implements ParentServerTemplate {

    String BASE_URL = "https://group-chat-parent-server.herokuapp.com/api/";
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Profile> getProfiles() {

        Profile[] profiles = restTemplate.getForObject(BASE_URL + "profile/", Profile[].class);
        //TODO Cheama endpoint-ul din serverul parinte pentru a luat toate profilele.
        return Arrays.asList(profiles);
    }

    @Override
    public Profile createProfile(CreateProfileRequest createProfileRequest) {

        //TODO Cheama endpoint-ul din serverul parinte pentru a crea profilul.
        return restTemplate.postForObject(BASE_URL + "profile/", createProfileRequest, Profile.class);
    }

    @Override
    public void connect(String id) {
        //TODO Cheama endpoint-ul din serverul parinte pentru a te conecta.
        restTemplate.postForEntity(BASE_URL + "connection/connect/" + id, null, Void.class);


    }

    @Override
    public void disconnect(String id) {
        //TODO Cheama endpoint-ul din serverul parinte pentru a te deconecta.
        restTemplate.postForEntity(BASE_URL + "connection/disconnect/" + id, null, Void.class);

    }

    @Override
    public List<MessageResponse> getMessages() {
        MessageResponse[] messageResponse = restTemplate.getForObject(BASE_URL + "chat/", MessageResponse[].class);
        //TODO Cheama endpoint-ul din serverul parinte pentru a lua toate mesajele.
        return Arrays.asList(messageResponse);
    }

    @Override
    public List<MessageResponse> sendMessage(CreateMessageRequest createMessageRequest) {
        //TODO Cheama endpoint-ul din serverul parinte pentru a lua crea un mesaj.
        MessageResponse[] messageResponses = restTemplate.postForObject(BASE_URL + "chat/", createMessageRequest, MessageResponse[].class);
        return Arrays.asList(messageResponses);
    }
}
