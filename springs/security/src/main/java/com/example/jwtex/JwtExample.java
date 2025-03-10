package com.example.jwtex;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jdk.jfr.DataAmount;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;


public class JwtExample {
    public static void main(String[] args) {
        //시크릿키를 생성
        //SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        //이번엔 시크릿키를 직접 지정하고 암호화
        String secret = "abcdefghijklmnopqrstuvwxzy123456";
        byte[] bytes = secret.getBytes(StandardCharsets.UTF_8);
        SecretKey secretKey = Keys.hmacShaKeyFor(bytes);
        //토큰을 생성
        String jwt = Jwts.builder()
                .setIssuer("ㅎㅇ")
                .setSubject("아이디")
                .setExpiration(new Date(System.currentTimeMillis()+36000))
                .claim("role", "ADMIN")
                .signWith(secretKey)
                .compact();

        System.out.println(jwt);
        String cpy = jwt;
       // System.out.println(cpy);


        //jwt 파싱, 검증
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(jwt)
                .getBody();

        System.out.println(claims.getExpiration());
        System.out.println(claims.getSubject());
        System.out.println(claims.getAudience());
    }
}
