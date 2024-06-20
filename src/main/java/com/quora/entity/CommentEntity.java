package com.quora.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "comments_table")
public class CommentEntity extends BaseEntity{

    @OneToOne
    private UserEntity user;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "answerId", nullable = false)
    private AnswerEntity answer;
}
