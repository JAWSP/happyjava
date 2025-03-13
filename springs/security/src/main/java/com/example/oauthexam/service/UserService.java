package com.example.oauthexam.service;

import com.example.oauthexam.dto.SocialUserRequestDto;
import com.example.oauthexam.entity.Role;
import com.example.oauthexam.entity.User;
import com.example.oauthexam.repository.RoleRepository;
import com.example.oauthexam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    //private final PasswordEncoder passwordEncoder;

    @Transactional
    public User saveUser(SocialUserRequestDto dto, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setSocialId(dto.getSocialId());
        user.setProvider(dto.getProvider());
        user.setPassword(passwordEncoder.encode(""));

//        User.builder()
//                .username(dto.getUsername())
//                .name(dto.getName())
//                .email(dto.getEmail())
//                .socialId(dto.getSocialId())
//                .provider(dto.getProvider())
//                .password(passwordEncoder.encode("")) //소셜로그인으로 진행시 사용자는 비밂번호를 비워둔다
//                .build();

        //log.info("떴냐?");
        Role userRole = roleRepository.findByName("User").orElseThrow();

        user.setRoles(Collections.singleton(userRole));

        //log.info("떴냐?@@@@@@@@@@@@@@@@@@@@@ {}", user.getEmail());
        //log.info("떴냐?@@@@@@@@@@@@@@@@@@@@@ {}", dto.getEmail());

        user.setEmail(dto.getEmail());
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
