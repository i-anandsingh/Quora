package com.quora.repository;

import com.quora.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LikeManagementRepository extends JpaRepository<LikeEntity, UUID> {
}
