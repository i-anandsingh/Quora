package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "answers_table")
public class AnswerEntity extends BaseEntity{
    @Id
    @Column(nullable = false)
    private UUID answer_id;

    @Column(nullable = false)
    private UUID question_id;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private UUID user_id;
}
