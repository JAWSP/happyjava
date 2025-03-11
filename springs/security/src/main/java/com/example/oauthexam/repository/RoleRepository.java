package com.example.oauthexam.repository;

import com.example.oauthexam.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<com.example.oauthexam.entity.Role, Long> {
    Optional<Role> findByName(String name);
}
