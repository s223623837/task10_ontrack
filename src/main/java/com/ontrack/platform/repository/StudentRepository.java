package com.ontrack.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontrack.platform.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Add custom query methods if needed
}

