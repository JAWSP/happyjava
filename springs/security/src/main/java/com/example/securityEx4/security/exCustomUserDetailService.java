//package com.example.securityEx4.security;
//
//import com.example.securityEx4.domain.Role;
//import com.example.securityEx4.domain.User;
//import com.example.securityEx4.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//
////일단은 시큐리티쪽의 서비스
//@Service
//@RequiredArgsConstructor
//@Slf4j
////impl부분은 약속임
//public class exCustomUserDetailService implements UserDetailsService {
//    private final UserRepository userRepository;
//    //얠 구현해야 함
//    //왜냐고? 그 유저를 DB뿐만 아니라 시큐리티까지 등록해야지
//    //로그인작업을 하면 시큐리티가 이 메소드를 참조해서 갸가 갸인지 파악하게 된다
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + user.getUsername());
//        if (user == null) {
//            throw new UsernameNotFoundException(username + "없");
//        }
//        //이름이 같은 User가 2개라서 import했던 대로의 경로를 가져와야 한다
//        UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
//        userBuilder.password(user.getPassword());
//        //roles는 set로 되어 있어서 이렇게 해야 한다
//        userBuilder.roles(user.getRoles().stream()
//                .map(Role::getName)
//                .toList()
//                .toArray(new String[0]));
//       // return null ;
//    }
//}
