package com.quora.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "answers_table")
public class AnswerEntity extends BaseEntity{

    @ManyToOne
    private QuestionEntity question;

    @Column(nullable = false)
    private String answer;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.REMOVE)
    private List<CommentEntity> commentEntityList;

    @OneToOne
    private UserEntity user;
}