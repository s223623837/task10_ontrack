package com.ontrack.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontrack.platform.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Add custom query methods if needed
}

