package com.quora.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users_table")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserEntity extends BaseEntity{

    @Column(nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "emailId")
    private String emailId;

    @Column(name = "bio")
    private String bio;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<QuestionEntity> questions;

    @OneToMany(mappedBy = "follower", cascade = CascadeType.REMOVE)
    private List<FollowEntity> follower;

    @OneToMany(mappedBy = "following", cascade = CascadeType.REMOVE)
    private List<FollowEntity> following;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<LikeEntity> likes;
}
