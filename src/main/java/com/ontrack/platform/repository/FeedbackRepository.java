package com.ontrack.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontrack.platform.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // Add custom query methods if needed
    List<Feedback> findByTaskId(Long taskId);

}

