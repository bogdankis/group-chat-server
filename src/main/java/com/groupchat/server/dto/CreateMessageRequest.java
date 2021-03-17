package com.groupchat.server.dto;

import lombok.Data;

@Data
public class CreateMessageRequest {
    private String senderId; //Il vei primi gol. Mi-a fost lene sa mai creez un obiect.
    private String message;
}
