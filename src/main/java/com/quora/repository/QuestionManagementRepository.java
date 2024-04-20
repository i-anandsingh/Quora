package com.quora.repository;

import com.quora.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestionManagementRepository extends JpaRepository<QuestionEntity, UUID> {
}
