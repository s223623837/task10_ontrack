package com.ontrack.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ontrack.platform.model.ChatMessage;
import com.ontrack.platform.model.Task;
import com.ontrack.platform.service.ChatMessageService;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/chat-messages")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping
    public ResponseEntity<List<ChatMessage>> getChatMessagesForTask(@PathVariable Long taskId) {
        List<ChatMessage> chatMessages = chatMessageService.findByTaskId(taskId);
        return ResponseEntity.ok(chatMessages);
    }

    @PostMapping
    public ResponseEntity<ChatMessage> addChatMessageForTask(@PathVariable Long taskId, @RequestBody ChatMessage chatMessage) {
        chatMessage.setTask(new Task(taskId)); // Assuming task ID is provided in the request body or path
        ChatMessage createdChatMessage = chatMessageService.save(chatMessage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdChatMessage);
    }

    @PutMapping("/{messageId}")
    public ResponseEntity<ChatMessage> updateChatMessageForTask(@PathVariable Long taskId, @PathVariable Long messageId, @RequestBody ChatMessage chatMessage) {
        ChatMessage existingChatMessage = chatMessageService.findById(messageId);
        if (existingChatMessage == null || !existingChatMessage.getTask().getId().equals(taskId)) {
            return ResponseEntity.notFound().build();
        }
        chatMessage.setId(messageId);
        chatMessage.setTask(new Task(taskId));
        ChatMessage updatedChatMessage = chatMessageService.save(chatMessage);
        return ResponseEntity.ok(updatedChatMessage);
    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<Void> deleteChatMessageForTask(@PathVariable Long taskId, @PathVariable Long messageId) {
        ChatMessage existingChatMessage = chatMessageService.findById(messageId);
        if (existingChatMessage == null || !existingChatMessage.getTask().getId().equals(taskId)) {
            return ResponseEntity.notFound().build();
        }
        chatMessageService.deleteById(messageId);
        return ResponseEntity.noContent().build();
    }
}
