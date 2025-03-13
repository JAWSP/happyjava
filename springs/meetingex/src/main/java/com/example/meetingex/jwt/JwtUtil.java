package com.example.meetingex.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class JwtUtil {
    // 시크릿(아이돌 그룹 아님)
    private static final String SECRET = "my-secret-key";
    //1시간짜리 수명
    private static final long EXPIRATION_TIME = 1000 * 60 * 60;
    //고오급 map, 아마 쓰레기통 포지션인가봐
    private final ConcurrentHashMap<String, Boolean> invalidTokens = new ConcurrentHashMap<>();

    public String generateToken(Long userId) {
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET));
    }

    //토큰 확인?
    public Long validateToken(String token) {
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            //일단 쓰레기통에 들어있는 놈이면 아닌거
            if (invalidTokens.containsKey(token)) {
                return null;
            }
            //일단 암호화한걸 복호화시키고 서명을 하는거라고 한다
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
           log.info("너는 누구냐? @@@@@@@@@@@@@@@@@@@@@@@@@@@ {}", Long.parseLong(decodedJWT.getSubject()));
            return Long.parseLong(decodedJWT.getSubject());
        } catch (JWTVerificationException | NumberFormatException e) {
            //대충 에러나면 아닌거임
            return null;
        }
    }

    //토큰 파기
    public void invalidateToken(String token) {
        //근데 파기인데 왜 넣는거지?
        //저 리스트는 파기된 토큰?
        invalidTokens.put(token, true);
    }
}
