package com.example.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //인증에 대한 설정
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/hello", "loginForm").permitAll()//인증 없이 접근 가능
                .anyRequest().authenticated()//모든 요청에 인증을 요구
        ).formLogin(f -> f
                .loginPage("loginForm")
                .defaultSuccessUrl("/success")
                .failureUrl("/fail")
                .usernameParameter("userId")
                .passwordParameter("passowrd")
        );
                //.formLogin(Customizer.withDefaults()); //얜 기본설정



        //다음 체인이 없을때 build로 끝낼수 있음
        return http.build();

    }
}
