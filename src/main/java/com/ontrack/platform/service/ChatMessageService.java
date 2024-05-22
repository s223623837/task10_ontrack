package com.ontrack.platform.service;

import java.util.List;

import com.ontrack.platform.model.ChatMessage;

public interface ChatMessageService {
    ChatMessage findById(Long id);
    List<ChatMessage> findAll();
    ChatMessage save(ChatMessage chatMessage);
    void deleteById(Long id);
    List<ChatMessage> findByTaskId(Long taskId);

}

