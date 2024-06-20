package com.quora.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "likes_table")
public class LikeEntity extends BaseEntity {
//    @Id
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Like type;

    @OneToOne
    private UserEntity user;
}
