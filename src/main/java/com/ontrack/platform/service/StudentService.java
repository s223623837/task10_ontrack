package com.ontrack.platform.service;

import java.util.List;

import com.ontrack.platform.model.Student;

public interface StudentService {
    Student findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    void deleteById(Long id);
}

