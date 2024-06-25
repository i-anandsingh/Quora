package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "topics_table")
public class TopicEntity extends BaseEntity{

    @Column(nullable = false)
    private String topics;
}
