package com.example.jwtex.config;

import com.example.jwtex.jwt.exception.CustomAuthEntryPoint;
import com.example.jwtex.jwt.filter.JwtAuthFilter;
import com.example.jwtex.jwt.util.JwtTokenizer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthEntryPoint customAuthEntryPoint;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
        security
                //POST를 원할하게 하기위한 csrf
                .csrf().disable()
                //new안에 new를 넣기엔 그러니까 저렇게 따로 빼준다
                //요 필터가 시큐리티에게 유저 정보와 jwt를 넣어준다
                //2번째 필터는 저 필터 이후로 해달라고 하는거
                .addFilterBefore(new JwtAuthFilter(jwtTokenizer), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth ->auth
                        .requestMatchers("/login", "/loginform").permitAll()
                        .anyRequest().authenticated())
                //일단 로그인은 우리가 할꺼니까 기본 로그인 설정은 꺼둔다
                .formLogin(form -> form.disable())
                //세션 저장은 안시키겠다 jesssion토큰 대신에 jwt를 쓸거니까
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //http베이직은 헤더에서 보안에 취약하고 쟤를 빼버리고, 다른 인증수단인 베어러(얜 이거 빼면 자동으로 지정됨)으로 한다고 한다
                .httpBasic(httpBasic -> httpBasic.disable())
                //cors는 허용범위를 지정해주는얘
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                //로그인시 발생하는 예외처리는 이렇게 할거라고 추가해준다
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(customAuthEntryPoint));

        return security.build();

    }

    //cors에 대한 설정
    //요청이 들어오면 어디까지 허용할꺼냐
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //혀용을 어디까지 허용할꺼냐를 설정한다
        //헤더, 메서드, 오리진 HTTP메서드...
        config.addAllowedOrigin("*"); //origin는 naver,goole,localhost같은거
        config.addAllowedHeader("*"); //베어러는 여기에 포함된다
        config.addAllowedMethod("*");
        config.setAllowedMethods(List.of("GET","POST","DELETE"));
        //그리고 그걸 적용할 url에 내가 설정한 부분을 적용시킬거라고 한다
        source.registerCorsConfiguration("/**",config);
        return source;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
