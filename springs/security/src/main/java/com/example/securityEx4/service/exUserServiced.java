//package com.example.securityEx4.service;
//
//import com.example.securityEx4.domain.Role;
//import com.example.securityEx4.domain.User;
//import com.example.securityEx4.domain.UserRegisterDTO;
//import com.example.securityEx4.repository.RoleRepository;
//import com.example.securityEx4.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collections;
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class exUserServiced {
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    //얜 패스워드를 인코딩 시키기 위한거
//    private final PasswordEncoder passwordEncoder;
//
//    //가입
//    @Transactional
//    public User registUser(User user) {
//        //유저 권한을 넣어주기 위하여 role에서 user를 꺼내준다
//        Role userRole = roleRepository.findByName("USER").get();
//        //이렇게 넣어준다, 싱글톤으로 넣어주는게 나중에 관리하기 편리하다고
//        user.setRoles(Collections.singleton(userRole));
//
//        //패스워드는 인코딩 시켜야 한다
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        return userRepository.save(user);
//
//    }
//
//    public User registUser(UserRegisterDTO userRegisterDTO) {
//        String encodedPassword = passwordEncoder.encode(userRegisterDTO.getPassword());
//
//        //Role를 가져와서stream으로 객체 만들어서 Set로 넣어주기
//        Set<Role> roles = userRegisterDTO.getRoles().stream()
//                .map(roleRepository::findByName)
//                .flatMap(Optional::stream) //Optional에 값이 비어져있다면, 무시하고 값만 추출
//                .collect(Collections.toSet());
//
//        User user = new User(userRegisterDTO.getUsername(), encodedPassword, userRegisterDTO.getName(), userRegisterDTO.getEmail(), roles);
//
//        return userRepository.save(user);
//
//    }
//    //유저가 존재하는지 채크 ->근데 이거 unique옵션으로 이미 방지되는거 아닌가
//    public boolean existUSer(String username) {
//        return userRepository.existsByUsername(username);
//    }
//}
