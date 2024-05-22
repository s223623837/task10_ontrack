package com.ontrack.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontrack.platform.model.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    // Add custom query methods if needed
    List<ChatMessage> findByTaskId(Long taskId);

}

