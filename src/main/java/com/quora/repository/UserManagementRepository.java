package com.quora.repository;

import com.quora.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface UserManagementRepository extends JpaRepository<UserEntity, String> {
    UserEntity findById(UUID Id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE USER_DETAILS U SET U.BIO = :bio WHERE U.USERID = :Id", nativeQuery = true)
    void updateUserDetailsById(String bio, UUID Id);
}
