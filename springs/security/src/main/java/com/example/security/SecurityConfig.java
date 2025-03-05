package com.example.security;

import jakarta.servlet.http.HttpSession;
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
                .requestMatchers("/hello", "loginForm", "/fail").permitAll()//인증 없이 접근 가능
                .anyRequest().authenticated()//모든 요청에 인증을 요구
        ).formLogin(f -> f
                //.loginPage("/loginForm")//로그인 페이지를 설정
                .defaultSuccessUrl("/success")
                .failureUrl("/fail")
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginProcessingUrl("/login_proc")//로그인 처리과정을 설정
                .successHandler((request, response, authentication) ->
                {log.info("이게 되네" + authentication.getName());
                    //얜 성공시 처리되는 메서드
                    response.sendRedirect("/info");
                    //성공시 처리하는 메소드
                    //3번째는 시큐리티가 로그인 성공한 것에 대해 컨택스트 등록시키는 객체(로컬스레드임)
                }).failureHandler(((request, response, exception) -> {
                    log.info("그게 안됨?"+ exception.getMessage());
                    response.sendRedirect("/login");
                        }))


        );
                //.formLogin(Customizer.withDefaults()); //얜 기본설정
        http
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/hello")
                        .addLogoutHandler(((request, response, authentication) ->  {
                            log.info("너 로그아웃 했다");
                            HttpSession session = request.getSession();
                            //세션 지우기
                            if (session != null) {
                                session.invalidate();
                            }
                        }))
                        //쿠키 지우기
                        .deleteCookies("JSESSIONID")
                );



        //다음 체인이 없을때 build로 끝낼수 있음
        return http.build();

    }
}
