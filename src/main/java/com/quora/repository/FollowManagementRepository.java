package com.quora.repository;

import com.quora.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FollowManagementRepository extends JpaRepository<FollowEntity, UUID> {
}
