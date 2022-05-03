package com.open.chatdemoapi.service;

import com.open.chatdemoapi.dto.ChatDTO;
import com.open.chatdemoapi.external.MsCacheManager;
import com.open.chatdemoapi.map.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private MsCacheManager ms;

    public HashMap<String, Object> create(ChatDTO chatDTO) {
        return ms.create(Mapper.map(chatDTO));
    }

    public List<?> getAll() {
        return ms.getAllkeys();
    }
}
