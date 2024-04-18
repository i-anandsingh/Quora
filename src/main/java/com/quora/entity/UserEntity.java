package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity(name = "User_Details")
public class UserEntity implements Serializable {

    @Id
    @Column(nullable = false, name = "USERID")
    private String userId;

    @Column(nullable = false, name = "EMAILID")
    private String emailId;

    @Column(name = "BIO")
    private String bio;
}
