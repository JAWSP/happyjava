package com.example.oauthexam.security;

import com.example.oauthexam.entity.Role;
import com.example.oauthexam.entity.SocialLoginInfo;
import com.example.oauthexam.entity.User;
import com.example.oauthexam.service.SocialLoginInfoService;
import com.example.oauthexam.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
//OAuth가 성공시 진행하는 핸들러들
public class CustomOauth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final UserService userService;
    private final SocialLoginInfoService socialLoginInfoService;



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //요청정보로부터 provider를 얻어올 수 있다
        //redirect-uri : "{baseUrl}/login/oauth2/code/{registrationId}"
        //baseUrl는 어느 소셜에 따라 다른다, 구글, 깃허브...
        //{registrationId}는 그 소셜의 id값이라고
        String requestURI = request.getRequestURI();
        String provider = extractProviderFromUri(requestURI);

        //근데 그 뒤도 없으면? 문제가 있는거지
        if (provider == null) {
            response.sendRedirect("/");
            return;
        }

        //인증객체에서 소셜유저의 정보를 가져온다
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        DefaultOAuth2User defaultOAuth2User = (DefaultOAuth2User) authentication.getPrincipal();

        String socialId = defaultOAuth2User.getAttributes().get("id").toString();
        String name = defaultOAuth2User.getAttributes().get("name").toString();

        Optional<User> existUser = userService.findByProviderAndSocialId(provider, socialId);

        //그리고 그 유저가 우리 서비스에 정보가 있냐 없냐
        //그거에 따라 디라이렉트 시키라고 응답객체에 보낸다
        if (existUser.isPresent()) {
            //유저 정보가 있다면? 기존 손님이네?
            User user = existUser.get();
            CustomUserDetails customUserDetails = new CustomUserDetails(user.getUsername(),
                    user.getPassword(),
                    user.getName(),
                    user.getRoles()
                            .stream()
                            .map(Role::getName)
                            .collect(Collectors.toList()));

            //실제로 저 긴게 있다고
            //암튼 저 긴걸로 인증정보를 만들고
            //그리고 그인증정보를 홀더에다 넣어둔다
            Authentication newAuth = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(newAuth);

            response.sendRedirect("/welcome");
        } else {
            //로그인이 성공했긴 한데 DB에 없다? 첫손님이네?
            //그럼 등록해줘야지
            SocialLoginInfo socialLoginInfo = socialLoginInfoService.saveSocialLoginInfo(provider, socialId);
            response.sendRedirect("/registerSocialUser?provider="+provider+"&socialId="+socialId+"&name="+name+"&uuid="+socialLoginInfo.getUuid());
        }
    }

    //localhost:8080/login/oauth2/code/github
    //매개변수에 실제로는 이렇게 들어올듯
    private String extractProviderFromUri(String uri) {
        //없으면 나가리
        if(uri == null || uri.isBlank()) {
            return null;
        }
        //만약 oauth2의 양식이 아니면 나가리
        if(!uri.startsWith("/login/oauth2/code/")){
            return null;
        }

        //제대로 가져왔다면? 우린 맨마지막 소셜id값만 필요하다
        // 예: /login/oauth2/code/github -> github만 필요하다고
        //그래서 스플릿으로 다 나눠서, 맨끝(길이 -1)번째를 반환한다
        String[] segments = uri.split("/");
        return segments[segments.length - 1];
    }
}
