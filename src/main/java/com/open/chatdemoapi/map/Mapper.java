package com.open.chatdemoapi.map;

import com.open.chatdemoapi.dto.ChatDTO;
import com.open.chatdemoapi.dto.UserDTO;
import com.open.chatdemoapi.model.Cache;

public class Mapper {

    public static Cache map(ChatDTO chatDTO) {
        return Cache.builder()
                .key(null)
                .content(chatDTO)
                .ttl(1200)
                .build();
    }

    public static Cache map(UserDTO userDTO) {
        return Cache.builder()
                .key(userDTO.getUsername())
                .content(userDTO)
                .ttl(1200)
                .build();
    }
}
