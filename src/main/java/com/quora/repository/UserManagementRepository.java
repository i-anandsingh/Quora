package com.quora.repository;

import com.quora.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserManagementRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUsername(String username);

    UserEntity findByEmailId(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USERS_TABLE U SET U.BIO = :bio WHERE U.USERNAME = :username", nativeQuery = true)
    void updateUserDetailsById(String bio, String username);
}
