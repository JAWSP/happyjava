package com.example.beforesecurity;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//필터 설정임
//이걸 쓰면 어노테이션을 쓰지 않아도 된다
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<newFilter> newFilter() {
        FilterRegistrationBean<newFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new newFilter());
        registrationBean.addUrlPatterns("/test/*");
        registrationBean.setOrder(1);
        return registrationBean;

    }

}
