package com.dauphine.job_portal_backend.repository;

import java.util.Optional;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dauphine.job_portal_backend.model.User;


public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<User> findIdByEmail(String email);
    @Query("SELECT u.role FROM User u WHERE u.id = :id")
    String getRoleById(UUID id);
}
