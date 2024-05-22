package com.ontrack.platform.model;

import lombok.Data;
import java.util.List;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // Relationships
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<ChatMessage> chatMessages;
    
    public Student(Long id, String firstName, String lastName, String email, List<Task> tasks, List<Feedback> feedbacks, List<ChatMessage> chatMessages) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tasks = tasks;
        this.feedbacks = feedbacks;
        this.chatMessages = chatMessages;
    }
    
}

