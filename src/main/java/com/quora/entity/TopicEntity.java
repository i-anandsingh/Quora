package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "topics_table")
public class TopicEntity {
    @Id
    @Column(nullable = false, name = "topic_id")
    private UUID topic_id;

    @Column(nullable = false, name = "topic_name")
    private String name;
}
