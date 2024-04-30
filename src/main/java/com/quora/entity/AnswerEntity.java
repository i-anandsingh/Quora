package com.quora.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "answers_table")
public class AnswerEntity extends BaseEntity{
    @Id
    @Column(nullable = false)
    private UUID answerId;

    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)
    private QuestionEntity question;

    @Column(nullable = false)
    private String answer;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.REMOVE)
    private List<CommentEntity> commentEntityList;
}