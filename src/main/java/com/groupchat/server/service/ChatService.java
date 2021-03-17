package com.groupchat.server.service;

import com.groupchat.server.dto.CreateMessageRequest;
import com.groupchat.server.dto.MessageResponse;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ChatService {

    List<MessageResponse> sendMessage(@RequestBody CreateMessageRequest createMessageRequest) throws NotFoundException;

    List<MessageResponse> getMessages();
}
