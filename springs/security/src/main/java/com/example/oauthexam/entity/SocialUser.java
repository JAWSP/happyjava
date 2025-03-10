package com.example.oauthexam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//소셜 로그인시 소셜쪽이 가지고 있던 정보
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String socialId;
    private String provider;
    private String username;
    private String email;
    private String avatarUrl;
}
