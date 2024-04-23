package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "questions_table")
public class QuestionEntity {
    @Id
    @Column(nullable = false, name = "uuid")
    private UUID question_id;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "body")
    private String body;

    @Column(name = "topic tags")
    private List<String> topicTags;

    @Column(name = "created_at")
    private Date created_at;

    // FK from user_details_table
    @Column(nullable = false, name = "user_id")
    private UUID user_id;
}
