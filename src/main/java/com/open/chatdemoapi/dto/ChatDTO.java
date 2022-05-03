package com.open.chatdemoapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChatDTO {

    private String title;

    private List<String> users;
}
