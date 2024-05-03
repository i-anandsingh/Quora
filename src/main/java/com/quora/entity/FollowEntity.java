package com.quora.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "follow_table")
public class FollowEntity {
    @Id
    @Column(nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "followerId")
    private UserEntity follower;

    @ManyToOne
    @JoinColumn(name = "followingId")
    private UserEntity following;
}
