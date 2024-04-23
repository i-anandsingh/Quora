package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "comments_table")
public class CommentEntity {
    @Id
    @Column(nullable = false, name = "comment_id")
    private UUID comment_id;

    @Column(nullable = false, name = "parent_id")
    private UUID parent_id;

    @Column(nullable = false, name = "text")
    private String text;

    @Column(name = "created_id")
    private Date created_id;

    // FK from user_details_table
    @Column(nullable = false, name = "user_id")
    private UUID user_id;
}
