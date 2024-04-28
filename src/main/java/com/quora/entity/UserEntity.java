package com.quora.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "user_details_table")
public class UserEntity extends BaseEntity{

    @Column(nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "email_id")
    private String emailId;

    @Column(name = "bio")
    private String bio;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    List<QuestionEntity> questions = new ArrayList<>();
}
