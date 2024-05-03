package com.quora.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "topics_table")
public class TopicEntity extends BaseEntity{
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private List<String> topics;
}
