package com.example.oauthexam.repository;

import com.example.oauthexam.entity.SocialLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialLoginInfoRepository extends JpaRepository<SocialLoginInfo, Long> {
    //Optional<SocialLoginInfo> FindByProviderAndUuidAndSocialId(String provider, String uuid, String SocialId);

    Optional<SocialLoginInfo> findByProviderAndUuidAndSocialId(String provider, String uuid, String socialId);
}
