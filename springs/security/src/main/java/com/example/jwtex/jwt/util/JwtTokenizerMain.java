package com.example.jwtex.jwt.util;

import io.jsonwebtoken.Claims;

import java.util.Arrays;

public class JwtTokenizerMain {
    public static void main(String[] args) {
        JwtTokenizer jwtTokenizer = new JwtTokenizer("12345678901234567890123456789012", "12345678901234567890123456789012");
        byte[] secretKey = "12345678901234567890123456789012".getBytes();
        String accessToken = jwtTokenizer.createAccessToken(1L, "asd", "w", "wwe", Arrays.asList("ROLE_USER", "ROLE_ADMIN"));

        System.out.println(accessToken);
        String refreshToken = jwtTokenizer.createRefreshToken(1L, "asd", "w", "wwe", Arrays.asList("ROLE_USER", "ROLE_ADMIN"));

        System.out.println(refreshToken);

        Claims claims = jwtTokenizer.parseToken(accessToken,secretKey);
        System.out.println(claims.getSubject());
        System.out.println(claims.get("username"));

    }
}
