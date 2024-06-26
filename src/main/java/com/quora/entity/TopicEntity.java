package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "topics_table")
public class TopicEntity extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String topics;

    @ManyToMany(mappedBy = "topicTags")
    private List<QuestionEntity> questions;
}
