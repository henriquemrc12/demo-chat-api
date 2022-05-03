package com.open.chatdemoapi.external;

import com.open.chatdemoapi.model.Cache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;


@Component
public class MsCacheManager {

    @Value("${URL_MS}")
    private String URL_MS;

    private RestTemplate restTemplate;

    public MsCacheManager() {
        this.restTemplate = new RestTemplate();
    }

    public HashMap<String, Object> create(Cache cache) {
        try {
            ResponseEntity<HashMap> response = restTemplate.postForEntity(URL_MS, cache, HashMap.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void update(Cache cache) {
        try {
            restTemplate.put(URL_MS, cache);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<?> getAllkeys() {
        try {
            ResponseEntity<List> response = restTemplate.getForEntity(URL_MS, List.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Object getByKey(String key) {
        try {
            ResponseEntity<List> response = restTemplate.getForEntity(String.format("%s/%s", URL_MS, key), List.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void deleteByKey(String key) {
        try {
            restTemplate.delete(String.format("%s/%s", URL_MS, key));
            return;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
