package com.example.weblab2.tags;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {
    private String senderName;
    private String sendDateTime;
    private String messageText;
}

