package com.it.kirin.biz.config;

import com.it.kirin.biz.interceptor.TenantInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new TenantInterceptor()).addPathPatterns("/**");
    }
}
