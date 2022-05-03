package com.open.chatdemoapi.model;

import lombok.Builder;

@Builder
public class Cache {

    private String key;

    private int ttl;

    private Object content;
}
