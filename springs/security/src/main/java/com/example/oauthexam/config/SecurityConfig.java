package com.example.oauthexam.config;

import com.example.oauthexam.security.CustomOauth2AuthenticationSuccessHandler;
import com.example.oauthexam.service.SocialUserService;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final SocialUserService socialUserService;
    private final CustomOauth2AuthenticationSuccessHandler customOauth2AuthenticationSuccessHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {


        security
                .authorizeHttpRequests(auth -> auth
                        //기존 로그인 관련은 공개해야지 로그인을 하지
                        .requestMatchers("/loginform", "/userregform", "/").permitAll()
                        //소셜 로그인도 공개해야지 소셜 로그인을 하지
                        .requestMatchers("/oauth2/**", "/login/oauth2/code/github","/registerSocialUser","/saveSocialUser").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .httpBasic(httpBasic -> httpBasic.disable())
                //위까지가 이전에 했던것
                //아래 부터 oauth2에 대한 설정임
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/loginform")
                        .failureUrl("/loginFalure")
                        //여기가 본체
                        .userInfoEndpoint(userInfo -> userInfo
                                //이 유저 서비스는 시큐리티가 구현하고 있는거
                                //하지만 그 안은 내가 구현한거
                                .userService(this.oAuth2UserService())
                               )
                        //근데 DB저장 뿐만 아니라 추가적으로 그 정보를 컨택스트 홀더에 넣고 싶어
                        .successHandler(customOauth2AuthenticationSuccessHandler)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                        ;

        return security.build();
    }

    //소셜에서 정보를 준거를 DB에 저장하고, 토큰도 발급하고
    //<첫번째가 요청한 유저의 정보를 담은 객체, 두번째는 그 유저의 객체의 타입>
       @Bean
       public OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService() {
           DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
           return oauth2UserRequest -> {
               //DefaultOAuth2UserService엔 유저의 정보를 불러오는 내부 메서드가 있다
               OAuth2User oAuth2User = delegate.loadUser(oauth2UserRequest);

               //소셜 로그인이 되었을 경우 해당 소셜의 유저 정보를 얻어올 수 있다
               //그 정보를 처리하는 로직을 여기에 적을 수 있음

               //엑세스 토큰, 근데 얜 없어도 됨
               String token =  oauth2UserRequest.getAccessToken().getTokenValue();
               //주는 놈의 정보
               String provider = oauth2UserRequest.getClientRegistration().getRegistrationId();
               //로그인 하는 놈의 정보
               System.out.println(oAuth2User.getAttributes());
               String socialId = String.valueOf(oAuth2User.getAttributes().get("id"));
               String username = (String) oAuth2User.getAttributes().get("login");
               String email = (String)  oAuth2User.getAttributes().get("email");
               String avatarUrl = (String) oAuth2User.getAttributes().get("avatar_url");

               //그리고 여기에다가 그 인증 정보를 저장한다
               socialUserService.saveOrUpdateUser(socialId, provider, username,email, avatarUrl);
               return oAuth2User;
           };
       }

    //cors
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
