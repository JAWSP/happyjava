package com.example.securityEx4.config;

import com.example.securityEx4.security.CustomUserDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDataService customUserDataService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/signup", "user/userreg", "/user/loginform", "/user/", "user/userreg_role").permitAll()
                        .requestMatchers("user/welcome").hasRole("USER"))

        ;

        //로그인
        security
                .formLogin(form -> form
                        .loginPage("/user/loginform")
                        .loginProcessingUrl("/user/login")
                        .defaultSuccessUrl("/user/welcome")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/user/")
                );
        //세션
        security
                .sessionManagement(session -> session
                        //동시 접속 허용 횟수
                        .maximumSessions(1)
                        //동시에 로그인 되었으면 기존 것을 차단함, false가 기본값
                        //true시 동시에 로그인시 새로이 로그인 될 부분이 차단됨
                        .maxSessionsPreventsLogin(true)
                );

        security
                .userDetailsService(customUserDataService);

        return security.build();
    }

        @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
