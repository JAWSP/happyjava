package com.example.jwtex.repository;

import com.example.jwtex.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    //Optional쓰는 이유는 얘가 Null일경우 대처하기 위해서..?
    Optional<RefreshToken> findByValue(String value);
}
