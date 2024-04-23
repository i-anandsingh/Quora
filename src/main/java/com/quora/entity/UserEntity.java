package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity(name = "user_details_table")
public class UserEntity implements Serializable {

    @Id
    @Column(nullable = false, name = "user_id")
    private UUID user_id;

    @Column(nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "email_id")
    private String emailId;

    @Column(name = "bio")
    private String bio;
}
