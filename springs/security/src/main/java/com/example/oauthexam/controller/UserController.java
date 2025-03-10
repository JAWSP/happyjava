package com.example.oauthexam.controller;

import com.example.oauthexam.dto.SocialUserRequestDto;
import com.example.oauthexam.entity.SocialLoginInfo;
import com.example.oauthexam.security.CustomUserDetails;
import com.example.oauthexam.service.SocialLoginInfoService;
import com.example.oauthexam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final SocialLoginInfoService socialLoginInfoService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/loginform")
    public String loginform() {
        return "oauth/users/loginform";
    }

    @GetMapping("/registerSocialUser")
    //너는
    // response.sendRedirect("/registerSocialUser?provider="
    //            +provider+"&socialId="+socialId+"&name"+name+"&uuid"+socialLoginInfo.getUuid());
    //로 온거야
    public String registerSocialUser(@RequestParam("provider") String provider, @RequestParam("socialId") String socialId,
                                     @RequestParam("name") String name, @RequestParam("uuid")String uuid, Model model) {
        model.addAttribute("provider", provider);
        model.addAttribute("socialId", socialId);
        model.addAttribute("name", name);
        model.addAttribute("uuid", uuid);
        return "oauth/users/registerSocialUser";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "oauth/welcome";
    }

 //--새로--

    @PostMapping("/saveSocialUser")
    public String saveSocialUser(@ModelAttribute SocialUserRequestDto requestDto) {
        Optional<SocialLoginInfo> socialLoginInfoOptional =
                socialLoginInfoService.findByProviderAndUuidAndSocialId(requestDto.getProvider(), requestDto.getUuid(), requestDto.getSocialID());

        if (socialLoginInfoOptional.isPresent()) {
            SocialLoginInfo socialLoginInfo = socialLoginInfoOptional.get();
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(socialLoginInfo.getCreatedAt(), now);
            if (duration.toMinutes() > 20) { // 20분 이상 경과하면.. 에러 페이지로 리다이렉트
                return "redirect:/error";
            }

            userService.saveUser(requestDto, passwordEncoder);
            return "redirect:/info";
        } else {
            return "redirect:/error";
        }
    }

    @GetMapping("/info")
    public String info(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
        model.addAttribute("user", customUserDetails);
        return "oauth/info";
    }
}
