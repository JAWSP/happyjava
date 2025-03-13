package com.example.meetingex.controller;

import com.example.meetingex.dto.ErrorResponseDto;
import com.example.meetingex.dto.LoginResponseDto;
import com.example.meetingex.jwt.JwtUtil;
import com.example.meetingex.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> user) {
        return ResponseEntity.ok(userService.register(user.get("email"), user.get("password")));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> user) {
        String token = userService.login(user.get("email"), user.get("password"));

        return token != null ? ResponseEntity.ok(new LoginResponseDto(token)) : ResponseEntity.status(401).body(new ErrorResponseDto("야 로그인 안됨"));
    }
    //그거 필요
    @PostMapping("/logout")
    public ResponseEntity<?> logout( @RequestHeader("Authorization") String token ) {
        //대충 로그인

        //토큰인증 실패시
        if (jwtUtil.validateToken(token) == null)
            return ResponseEntity.status(401).body(new ErrorResponseDto("토큰이 이상함"));
        userService.logout(token);
        return ResponseEntity.ok("로그아웃 완료");
    }
}
