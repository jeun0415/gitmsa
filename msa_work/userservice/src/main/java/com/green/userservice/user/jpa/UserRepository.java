package com.green.userservice.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String reqEmail);

    Optional<UserEntity> findByEmailAndPassword(String email, String password);

    Optional<UserEntity> findByUserId(String userId);
}
