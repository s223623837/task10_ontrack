package com.ontrack.platform.service;

import java.util.List;

import com.ontrack.platform.model.Feedback;

public interface FeedbackService {
    Feedback findById(Long id);
    List<Feedback> findAll();
    Feedback save(Feedback feedback);
    void deleteById(Long id);
    List<Feedback> findByTaskId(Long taskId);

}

