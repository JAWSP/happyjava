package com.example.securityEx4.service;

//role서비스를 안쓰는 이유 -> 그냥 없어도 되어서

import com.example.securityEx4.domain.Role;
import com.example.securityEx4.domain.User;
import com.example.securityEx4.domain.UserRegisterDTO;
import com.example.securityEx4.repository.RoleRepository;
import com.example.securityEx4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    //패스워드
    private final PasswordEncoder passwordEncoder;

    //가입하기
    @Transactional
    public User registUser(User user) {
        //기본은 USER로 지정한다
        Role userRole = roleRepository.findByName("USER").get();
        //그에 대한 권한을 가져와서 싱글톤으로 붙여준다
        user.setRoles(Collections.singleton(userRole));

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public boolean existUser(String username) {
        return userRepository.existsByUsername(username);
    }

    //가입하기2
    @Transactional
    public User registUser(UserRegisterDTO userRegisterDTO) {
        log.info("@!!!!!!#!@#@!#@!$@$#@!#!#@!#");
        String endocedPassword = passwordEncoder.encode(userRegisterDTO.getPassword());
        //그러니까DTO안에 저장된 Roles를
        Set<Role> roles = userRegisterDTO.getRoles().stream()
                .map(r -> roleRepository.findByName(r))
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        user.setPassword(endocedPassword);
        user.setName(userRegisterDTO.getName());
        user.setEmail(userRegisterDTO.getEmail());
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
