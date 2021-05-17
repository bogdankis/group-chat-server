package com.groupchat.server.dto;

import lombok.Data;

@Data
public class CreateMessageRequest {
    private String senderId;
    private String message;
}
