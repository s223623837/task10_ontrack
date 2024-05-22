package com.ontrack.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ontrack.platform.model.Feedback;
import com.ontrack.platform.repository.FeedbackRepository;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public Feedback findById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback save(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }
    @Override
    public List<Feedback> findByTaskId(Long taskId) {
        return feedbackRepository.findByTaskId(taskId);
    }
}

