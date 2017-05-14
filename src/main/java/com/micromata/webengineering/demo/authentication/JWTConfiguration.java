package com.micromata.webengineering.demo.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfiguration {
    @Autowired
    private AuthenticationService authenticationService;

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new JWTFilter(authenticationService));
        bean.addUrlPatterns("/api/*");
        return bean;
    }
}
