package com.example.securityEx2;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, UserDetailsService userDetailService) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()

        )
                .formLogin(Customizer.withDefaults())
                .rememberMe(rememberMe -> rememberMe
                        .userDetailsService(userDetailService)
                )
        ;
        httpSecurity.logout(logout ->logout
                .addLogoutHandler((request, response, authentication) -> {
                    HttpSession session = request.getSession();
                    if (session != null)
                        session.invalidate();
                }));
        return httpSecurity.build();
    }
}
