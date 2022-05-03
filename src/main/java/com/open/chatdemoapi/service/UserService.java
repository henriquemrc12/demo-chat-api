package com.open.chatdemoapi.service;

import com.open.chatdemoapi.dto.UserDTO;
import com.open.chatdemoapi.external.MsCacheManager;
import com.open.chatdemoapi.map.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private MsCacheManager ms;

    public HashMap<String, Object> create(UserDTO userDTO) {
        return ms.create(Mapper.map(userDTO));
    }

    public List<?> getAll() {
        return ms.getAllkeys();
    }
}
