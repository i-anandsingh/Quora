package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "questions_table")
public class QuestionEntity {
    @Id
    @Column(nullable = false, name = "UUID")
    private UUID userId;

    @Column(nullable = false, name = "TITLE")
    private String title;

    @Column(nullable = false, name = "BODY")
    private String body;

    @Column(name = "TOPIC_TAGS")
    private List<String> topicTags;
}
