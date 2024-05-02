package com.quora.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "likes_table")
public class LikeEntity {
    @Id
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Like type;

    @OneToOne
    UserEntity user;
}
