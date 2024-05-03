package com.quora.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "topics_table")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TopicEntity extends BaseEntity{
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private List<String> topics;
}
