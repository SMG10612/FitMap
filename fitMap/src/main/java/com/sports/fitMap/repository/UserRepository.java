package com.sports.fitMap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sports.fitMap.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByEmail(String email);
    UserEntity findByEmailAndPassword(String email, String password);
}