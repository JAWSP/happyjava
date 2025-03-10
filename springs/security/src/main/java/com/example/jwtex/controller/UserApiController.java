package com.example.jwtex.controller;

import com.example.jwtex.domain.RefreshToken;
import com.example.jwtex.domain.Role;
import com.example.jwtex.domain.User;
import com.example.jwtex.dto.UserLoginResponseDto;
import com.example.jwtex.jwt.util.JwtTokenizer;
import com.example.jwtex.repository.RefreshTokenRepository;
import com.example.jwtex.security.dto.UserLoginDto;
import com.example.jwtex.service.RefreshTokenService;
import com.example.jwtex.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenizer jwtTokenizer;
    private final RefreshTokenService refreshTokenService;

    @GetMapping("/info")
    public String info() {
        return "info";
    }


    @PostMapping("/login")
    //리턴타입에 <?>를 넣어서 임의타입의 제너릭을 넣어도 됨
    public ResponseEntity login(@RequestBody UserLoginDto userLoginDto, HttpServletResponse response) {

        //1. username(id로 입력한거)가 일단 우리 서버에 등록되었는지 확인
        User user = userService.findUsername(userLoginDto.getUsername());
        if (user == null)
            return ResponseEntity.status(404).body("너 없잔아");
        //2. 그리고 패스워드를 비교한다
        if (!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("비번이 이상해");
        //3유저맞고 비밀번호 맞으면? 토큰줘야지

        //일단 역할을 뽑아
        List<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList());

        //그리고 토큰을 만들어

        //엑세스 토큰
        String accessToken = jwtTokenizer.createAccessToken(user.getId(), user.getEmail(), user.getUsername(),user.getName(), roles);

        //리프래시 토큰
        String refreshToken = jwtTokenizer.createRefreshToken(user.getId(), user.getEmail(), user.getUsername(),user.getName(), roles);
        //리프래시 토큰을 DB에 저장
        //어떻게? 엔티티 만들어서
        RefreshToken refreshTokenEntity = new RefreshToken();
        refreshTokenEntity.setValue(refreshToken);
        refreshTokenEntity.setUserId(user.getId());
       refreshTokenService.addRefreshToken(refreshTokenEntity);

       //만약 쿠키에도 저장하고 싶다면?
        Cookie accesTokenCookie = new Cookie("accessToken", accessToken);
        accesTokenCookie.setHttpOnly(true); //보안, 자바스크립트로는 안되고 http로만
        accesTokenCookie.setPath("/"); //쿠키 경로 지정, "/"는 모든 경로 "/아무개"는 특정 경로에만 쿠키가 전달된다
        //쿠키의 시간단위는 초단위 ,따라서 ms인 jwt단위에 1000을 나눠야한다
        accesTokenCookie.setMaxAge(Math.toIntExact(JwtTokenizer.ACCESS_TOKEN_EXPIRE_COUNT / 1000));


        Cookie refreshTokenCookie = new Cookie("refreshTokem", refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setMaxAge(Math.toIntExact(JwtTokenizer.REFRESH_TOKEN_EXPIRE_COUNT/1000));


        //그리고 응답객체에 그 쿠키를 넣어준다
        response.addCookie(accesTokenCookie);
        response.addCookie(refreshTokenCookie);

       //응답으로 보낼 값을 만든다
        UserLoginResponseDto loginResponseDto = UserLoginResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.getId())
                .name(user.getName())
                .build();
        return ResponseEntity.ok(loginResponseDto);
    }

    //엑세스 토큰이 만료될때 리프래시 토큰을 불러서 갱신해달라고 함
    //내부적으로 알아서 호출이 된다고
//    @PostMapping("/refreshtoken")
//    //저 제네릭은 임의의 제네릭인 뜻이며 안넣어도 됨
//    private ResponseEntity<?> refreshtoken() {
//        //리프래시 토큰을 받으면 일단은 그게 맞나 인증을 해야지
//    }
}
