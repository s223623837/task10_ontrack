package com.ontrack.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ontrack.platform.model.Feedback;
import com.ontrack.platform.model.Task;
import com.ontrack.platform.service.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<Feedback>> getFeedbackForTask(@PathVariable Long taskId) {
        List<Feedback> feedbacks = feedbackService.findByTaskId(taskId);
        return ResponseEntity.ok(feedbacks);
    }

    @PostMapping
    public ResponseEntity<Feedback> addFeedbackForTask(@PathVariable Long taskId, @RequestBody Feedback feedback) {
        feedback.setTask(new Task(taskId)); // Assuming task ID is provided in the request body or path
        Feedback createdFeedback = feedbackService.save(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedback);
    }

    @PutMapping("/{feedbackId}")
    public ResponseEntity<Feedback> updateFeedbackForTask(@PathVariable Long taskId, @PathVariable Long feedbackId, @RequestBody Feedback feedback) {
        Feedback existingFeedback = feedbackService.findById(feedbackId);
        if (existingFeedback == null || !existingFeedback.getTask().getId().equals(taskId)) {
            return ResponseEntity.notFound().build();
        }
        feedback.setId(feedbackId);
        feedback.setTask(new Task(taskId));
        Feedback updatedFeedback = feedbackService.save(feedback);
        return ResponseEntity.ok(updatedFeedback);
    }

    @DeleteMapping("/{feedbackId}")
    public ResponseEntity<Void> deleteFeedbackForTask(@PathVariable Long taskId, @PathVariable Long feedbackId) {
        Feedback existingFeedback = feedbackService.findById(feedbackId);
        if (existingFeedback == null || !existingFeedback.getTask().getId().equals(taskId)) {
            return ResponseEntity.notFound().build();
        }
        feedbackService.deleteById(feedbackId);
        return ResponseEntity.noContent().build();
    }
}

