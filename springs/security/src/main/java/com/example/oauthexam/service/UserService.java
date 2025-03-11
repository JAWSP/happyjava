package com.example.oauthexam.service;

import com.example.oauthexam.dto.SocialUserRequestDto;
import com.example.oauthexam.entity.Role;
import com.example.oauthexam.entity.User;
import com.example.oauthexam.repository.RoleRepository;
import com.example.oauthexam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    //private final PasswordEncoder passwordEncoder;

    @Transactional
    public User saveUser(SocialUserRequestDto dto, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.builder()
                .username(dto.getUsername())
                .name(dto.getName())
                .email(dto.getEmail())
                .socialId(dto.getSocialID())
                .provider(dto.getProvider())
                .password(passwordEncoder.encode("")) //소셜로그인으로 진행시 사용자는 비밂번호를 비워둔다
                .build();
        Role uerRole = roleRepository.findByName("User").orElseThrow();



        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    //2차로그인시 저 요청이 우리 DB에 있나 확인
    @Transactional(readOnly = true)
    public Optional<User> findByProviderAndSocialId(String provider, String socialId) {
        return userRepository.findByProviderAndSocialId(provider, socialId);
    }


}
