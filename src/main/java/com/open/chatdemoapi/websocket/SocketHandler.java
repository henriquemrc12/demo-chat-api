package com.open.chatdemoapi.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class SocketHandler extends TextWebSocketHandler {

    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws IOException {
        for (WebSocketSession webSocketSession : sessions) {
            if (!session.equals(webSocketSession)) {
                String currentChatId = session.getAttributes().get("chatId").toString();
                String chatId = webSocketSession.getAttributes().get("chatId").toString();
                if (currentChatId.equalsIgnoreCase(chatId)) {
                    webSocketSession.sendMessage(message);
                }
            }
        }
    }
}