package com.example.beforesecurity;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class UserFIlter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            log.info("유저 필터 드가자" + Thread.currentThread().getName());
//            //만약에 요청객체에 이름을 받아서 유저를 설저앟고 싶다면?
//            String name = servletRequest.getParameter("name");
//            //로컬 스레드 객체를 생성
//            UserContext.setUser(new User(name));

            //이렇게도 가능
            User user = extractUserFromRequest(servletRequest);
            UserContext.setUser(user);
            filterChain.doFilter(servletRequest, servletResponse);
            log.info("거 끝나기 딱 좋은 날씨구만" + Thread.currentThread().getName());
        } finally {
            UserContext.clear();
        }

    }
    private User extractUserFromRequest(ServletRequest request) {
        //복잡한 로직을 통해서 정보를 추출하고 싶다면?
        String name = request.getParameter("name");
        return new User(name);
    }
}
