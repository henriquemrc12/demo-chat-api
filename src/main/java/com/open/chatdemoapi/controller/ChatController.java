package com.open.chatdemoapi.controller;

import com.open.chatdemoapi.dto.ChatDTO;
import com.open.chatdemoapi.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/chat")
public class ChatController {

    @Autowired
    private ChatService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ChatDTO chatDTO) {
        return ResponseEntity.ok().body(service.create(chatDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}
