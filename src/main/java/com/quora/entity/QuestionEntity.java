package com.quora.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "questions_table")
public class QuestionEntity extends BaseEntity{

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "body")
    private String body;

    private String topicTags;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    // A question can have many answers
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<AnswerEntity> answerList;

    @OneToOne
    private LikeEntity like;
}
