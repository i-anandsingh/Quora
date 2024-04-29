package com.quora.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "user_table")
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
    List<QuestionEntity> questions = new ArrayList<>();
}
