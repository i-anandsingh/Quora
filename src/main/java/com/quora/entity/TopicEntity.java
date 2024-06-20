package com.quora.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "topics_table")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TopicEntity extends BaseEntity{

    @Column(nullable = false)
    private String topics;
}
