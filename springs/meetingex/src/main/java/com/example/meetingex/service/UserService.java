package com.example.meetingex.service;

import com.example.meetingex.entity.User;
import com.example.meetingex.jwt.JwtUtil;
import com.example.meetingex.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    //가입
    @Transactional
    public String register(String email, String password) {
        if (userRepository.findByEmail(email).isPresent())
            return "너 이미 가입되어있음;;";
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "가입 ㅊㅊ 신병 받아라~";
    }

    //로긘
    //여기서 jwt가 발급되나보네
    public String login(String email, String password) {

        Optional<User> user = userRepository.findByEmail(email);
        //id가 맞는가? -> 유저에 DB에 저장되어있는가?
        //비번이 맞는거? -> 패스워드를 한번 밪는지 보기
        if (user.isPresent() && password.equals(user.get().getPassword())) {
            //맞으면 토큰을 발급
            //그럼 로그인 유지는? -> 그건 어차피 토큰 갖다 주는데 맞으면 그게 로그인 유지지
            return jwtUtil.generateToken(user.get().getId());
        }
        //없으면 null
        return null;
    }

    public void logout(String token) {
        //이건 토큰을 없애는 코드인가보다
        jwtUtil.invalidateToken(token);
    }

}
