package com.example.beforesecurity;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
////빈객체로 등록
//@Component
////필터임을 명시, 그 옆은 url로 들어갈때 발동인가봄
//@WebFilter(urlPatterns = "/test/*")
public class newFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("필터 시작임");
//    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("필터 do임"+Thread.currentThread().getName());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("필터 걸렀다"+Thread.currentThread().getName());
    }

    @Override
    public void destroy() {
        log.info("필터 부술꺼임");
    }
}
