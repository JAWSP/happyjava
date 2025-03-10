package com.example.oauthexam.service;

import com.example.oauthexam.entity.SocialUser;
import com.example.oauthexam.repository.SocialUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocialUserService {
    private final SocialUserRepository socialUserRepository;

    //소셜에서 보내준 정보를 저장하기 위한 메서드
    @Transactional
    public SocialUser saveOrUpdateUser(String socialId, String provder, String username,
                                       String email, String avatarUrl){
        //요청한 유저가 내 DB에 존재하냐?
       Optional<SocialUser> existUser = socialUserRepository.findBySocialIdAndProvider(socialId, provder);
       //초기화 안한 이유는 만약 있다면 기존걸
       SocialUser socialUser;
       //그 유저가 있다면 이미 로그인해봤단뜻, 즉 업데이트 시켜줌?
        //중간에 바뀔 수 있을테니 저걸 그대로 넣어준다
        //->근데 비효율적인 것 같은데
       if (existUser.isPresent()) {
           socialUser = existUser.get();
           socialUser.setUsername(username);
           socialUser.setEmail(email);
           socialUser.setAvatarUrl(avatarUrl);
       } else  {
           socialUser = new SocialUser();
           //아니면 처음 로그인한 경우
           socialUser.setSocialId(socialId);
           socialUser.setProvider(provder);
           socialUser.setUsername(username);
           socialUser.setEmail(email);
           socialUser.setAvatarUrl(avatarUrl);
       }
       return socialUserRepository.save(socialUser);
    }
}
