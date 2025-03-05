package com.example.securityEx3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {
    public String userLog() {
        String msg = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            msg = "쟤 로갓함";
        }
        Object principle = authentication.getPrincipal();
        if (principle instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principle;
            msg = "지금 너는 " + userDetails.getUsername();
        } else  {
            msg = "UserDetail하지 않은 너는 " + principle.toString();
        }

        return msg;
    }
}
