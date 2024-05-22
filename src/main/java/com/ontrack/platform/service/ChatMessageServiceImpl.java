package com.ontrack.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ontrack.platform.model.ChatMessage;
import com.ontrack.platform.repository.ChatMessageRepository;

import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessage findById(Long id) {
        return chatMessageRepository.findById(id).orElse(null);
    }

    @Override
    public List<ChatMessage> findAll() {
        return chatMessageRepository.findAll();
    }

    @Override
    public ChatMessage save(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    @Override
    public void deleteById(Long id) {
        chatMessageRepository.deleteById(id);
    }

    @Override
    public List<ChatMessage> findByTaskId(Long taskId) {
        return chatMessageRepository.findByTaskId(taskId);
    }
}

