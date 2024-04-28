package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "questions_table")
public class QuestionEntity extends BaseEntity{

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
