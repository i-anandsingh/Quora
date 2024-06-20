package com.quora.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "follow_table")
public class FollowEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "followerId")
    private UserEntity follower;

    @ManyToOne
    @JoinColumn(name = "followingId")
    private UserEntity following;
}
