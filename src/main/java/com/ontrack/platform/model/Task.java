package com.ontrack.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.*;


@Data
@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    // Relationships
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<ChatMessage> chatMessages;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    public Task(Long id) {
        this.id = id;
    }
}
