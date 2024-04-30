package com.quora.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "comments_table")
public class CommentEntity extends BaseEntity{
    @Id
    @Column(nullable = false)
    private UUID commentId;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "answerId", nullable = false)
    private AnswerEntity answer;
}
