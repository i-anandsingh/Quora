package com.quora.repository;

import com.quora.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUserId(String userId);
    @Modifying
    @Transactional
    @Query(value = "UPDATE USER_DETAILS U SET U.BIO = :bio WHERE U.USERID = :userId", nativeQuery = true)
    void updateUserDetailsById(String bio, String userId);
}
