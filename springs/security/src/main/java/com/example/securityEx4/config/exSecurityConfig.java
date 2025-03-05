//package com.example.securityEx4.config;
//
//import com.example.securityEx4.security.exCustomUserDetailService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@Slf4j
//@RequiredArgsConstructor
//public class exSecurityConfig {
//    private final exCustomUserDetailService customUserDetailService;
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
//        security
//                //post요청 보내면 요놈이 무조건 막아대서 일단은 껐음
//                .csrf(csrf ->csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/user/**", "/login").permitAll()
//                        .anyRequest().authenticated())
//                //파일 위치가 가닌 url로 접근이 된다
//                .formLogin(form -> form
//                        .loginPage("/user/login")
//                        .loginProcessingUrl("/login")
//                        .defaultSuccessUrl("/user/welcome")
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/")
//                )
//                .userDetailsService(customUserDetailService);
//        return security.build();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
