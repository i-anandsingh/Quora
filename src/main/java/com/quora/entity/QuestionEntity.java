package com.quora.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "questions_table")
public class QuestionEntity extends BaseEntity{
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "body")
    private String body;

    @Column(name = "topic tags")
    private List<String> topicTags;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;
}
