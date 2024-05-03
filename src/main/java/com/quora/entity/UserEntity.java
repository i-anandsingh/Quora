package com.quora.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "users_table")
public class UserEntity extends BaseEntity{
    @Id
    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "email_id")
    private String emailId;

    @Column(name = "bio")
    private String bio;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<QuestionEntity> questions;

    @OneToMany(mappedBy = "follower", cascade = CascadeType.REMOVE)
    private List<FollowEntity> follower;

    @OneToMany(mappedBy = "following", cascade = CascadeType.REMOVE)
    private List<FollowEntity> following;
}
