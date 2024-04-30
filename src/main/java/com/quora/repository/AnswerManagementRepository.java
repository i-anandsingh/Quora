package com.quora.repository;

import com.quora.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnswerManagementRepository extends JpaRepository<AnswerEntity, UUID> {
    AnswerEntity findByAnswerId(UUID answerId);
}
