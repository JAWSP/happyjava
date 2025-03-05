package com.example.securityEx3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity //요즘은 버전 업되어서 안붙여도 돌아가긴 한다고 한다
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hello", "*/shop/**", "/img/**", "*/static/**").permitAll()
                        //얜 특정 요청에 특정 인원들만 들어가게 권한을 줄 수 있다고 한다, 2개이사잉라서 AnyRole
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                        //얜 특정 요청에 ADMIN권한만 들어갈 수 있다고
                        .requestMatchers("/admin/asd").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/hello"));

        return httpSecurity.build();
    }

    // USER, ADMIN, SUPERUSER -> 3개의 role이 존재한다고 가정한다고한다

    //유저 디테일 객체를 만든다
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("asd"))
                .roles("USER")
                .build();
        //이렇게 권한을 여러개 추가해도 된다
        UserDetails user2 = User.withUsername("조물주")
                .password(passwordEncoder.encode("1234"))
                .roles("USER", "ADMIN")
                .build();

        UserDetails user3 = User.withUsername("super")
                .password(passwordEncoder.encode("super"))
                .roles("SUPERUSER")
                .build();
        return new InMemoryUserDetailsManager(user, user2, user3);
    }

    //패스워드를 암호화 해서 들어가게 만든다
    @Bean
    public PasswordEncoder passwordEncoder() {
        //얜 스프링이 기본적으로 제공해줌
        return new BCryptPasswordEncoder();
    }
}
