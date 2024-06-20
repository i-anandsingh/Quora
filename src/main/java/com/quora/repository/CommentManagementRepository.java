package com.quora.repository;

import com.quora.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentManagementRepository extends JpaRepository<CommentEntity, UUID> {
//    CommentEntity findByCommentId(UUID commentId);
}
