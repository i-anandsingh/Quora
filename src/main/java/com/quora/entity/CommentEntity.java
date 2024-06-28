package com.quora.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private CommentEntity parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<CommentEntity> childComment;
}
