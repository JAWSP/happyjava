package com.example.jwtex.service;

import com.example.jwtex.domain.RefreshToken;
import com.example.jwtex.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Ref;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final RefreshTokenRepository repository;

    //토큰을 DB에 저장
    @Transactional
    public RefreshToken addRefreshToken(RefreshToken refreshToken) {
        return repository.save(refreshToken);
    }

    @Transactional
    public void deleteRefreshToken(String refreshToken) {
        //repository::delete는 t -> repository.delete(t)와 같다
        repository.findByValue(refreshToken).ifPresent(repository::delete);
    }

    @Transactional
    public Optional<RefreshToken> findByRefreshToken(String token) {
        return repository.findByValue(token);
    }
}
