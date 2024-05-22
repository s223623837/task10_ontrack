package com.ontrack.platform.service;

import java.util.List;

import com.ontrack.platform.model.Task;

public interface TaskService {
    Task findById(Long id);
    List<Task> findAll();
    Task save(Task task);
    void deleteById(Long id);
}

