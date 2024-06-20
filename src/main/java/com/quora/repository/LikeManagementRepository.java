package com.quora.repository;

import com.quora.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LikeManagementRepository extends JpaRepository<LikeEntity, UUID> {
}
