package com.groupchat.server.service;

import com.groupchat.server.dto.CreateMessageRequest;
import com.groupchat.server.dto.CreateProfileRequest;
import com.groupchat.server.dto.MessageResponse;
import com.groupchat.server.model.Profile;

import java.util.List;

public interface ParentServerTemplate {
    List<Profile> getProfiles();

    Profile createProfile(CreateProfileRequest createProfileRequest);

    void connect(String id);

    void disconnect(String id);

    List<MessageResponse> getMessages();

    List<MessageResponse> sendMessage(CreateMessageRequest createMessageRequest);


}
