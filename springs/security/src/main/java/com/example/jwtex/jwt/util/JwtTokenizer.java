package com.example.jwtex.jwt.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenizer {
    private final byte[] accessSecret;
    private final byte[] refreshSecret;

    public static Long ACCESS_TOKEN_EXPIRE_COUNT=30*60*1000L; //이거 30분임 단위가 ms라서
    public static Long REFRESH_TOKEN_EXPIRE_COUNT=7*24*60*60*1000L; //이건 일주일

    //@Value는 환경변수를 꺼내는 어노테이션
    //직접 지정하는거라 롬보은 ㄴㄴ
    public JwtTokenizer(@Value("${jwt.secretKey}") String accessSecret, @Value("${jwt.refreshKey}") String refreshSecret) {
        this.accessSecret = accessSecret.getBytes(StandardCharsets.UTF_8);
        this.refreshSecret = refreshSecret.getBytes(StandardCharsets.UTF_8);
    }

    private String createToken(Long id, String email, String name,
                               String username, List<String>roles,
                               Long expire, byte[] secretKey) {
        //claims에 필요한 정보를 넣어준다
        Claims claims = Jwts.claims().setSubject(email);
        //키와 벨류로
        claims.put("name", name);
        claims.put("username", username);
        claims.put("userID", id);
        claims.put("roles", roles);
        return Jwts.builder()
                .setClaims(claims)
                //이건 언제 생성되었나
                .setIssuedAt(new Date())
                //이건 언제까지 유효가 되냐
                .setExpiration(new Date(new Date().getTime()+expire))
                //뭘로 시그니쳐를 할거냐
                .signWith(getSignKey(secretKey))
                .compact();
    }

    private static Key getSignKey(byte[] secretKey) {
        return Keys.hmacShaKeyFor(secretKey);
    }

    public String createAccessToken(Long id, String email, String username, String name, List<String> roles) {
        return createToken(id, email, name, username, roles, ACCESS_TOKEN_EXPIRE_COUNT, accessSecret);
    }

    public String createRefreshToken(Long id, String email, String name, String username, List<String> roles) {
        return createToken(id, email, name, username, roles, REFRESH_TOKEN_EXPIRE_COUNT, refreshSecret);
    }

    //받은 토큰을 파싱
    public Claims parseToken(String token, byte[] secretKey) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey(secretKey))
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    //시크릿키가 여기서 해결하는 경우
    public Claims parseAccessToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey(accessSecret))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Claims parseRefreshToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey(refreshSecret))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Long getUserIdFromToken(String token) {
        if (token == null || token.isBlank())
            throw new IllegalArgumentException("토큰이 없는댑쇼");

        //Bearer로 시작해야 토큰이라고
        //찾아보니 OAth2라는데...
        if (token.startsWith("Bearer ")) {
            throw new IllegalArgumentException("유효하지 않은 형식");
        }
        Claims claims = parseToken(token, accessSecret);
        if (claims == null)
            throw new IllegalArgumentException("토큰이 아파요");
        return (Long) claims.get("userID");
    }
}
