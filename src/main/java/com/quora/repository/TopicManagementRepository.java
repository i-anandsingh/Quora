package com.quora.repository;

import com.quora.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface TopicManagementRepository extends JpaRepository<TopicEntity, UUID> {
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM LIKES_TABLE",nativeQuery = true)
    List<TopicEntity> findALL();

    @Query(value = "SELECT * FROM TOPICS_TABLE WHERE TOPICS in ", nativeQuery = true)
    TopicEntity fetchIdByTopicTag(List<String> topicTag);

    TopicEntity findByTopics(String topic);
}
