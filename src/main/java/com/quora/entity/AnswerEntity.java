package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "answer_table")
public class AnswerEntity {
    @Id
    @Column(name = "answer_id")
    private UUID answer_id;

    // FK from questions_table
    @Column(name = "question_id")
    private UUID question_id;

    @Column(nullable = false, name = "text")
    private String text;

    @Column(name = "created_at")
    private Date created_at;

    // FK from user_details_table
    @Column(nullable = false, name = "user_id")
    private UUID user_id;
}
