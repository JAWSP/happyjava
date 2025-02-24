package com.example.rest.repository;

import com.example.rest.domain.ExUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExUserRepository extends JpaRepository<ExUser, Long> {
}
