package com.lizxing.aop.demo.config;

import com.lizxing.aop.demo.config.interceptor.SourceAccessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SourceAccessInterceptor())
                .addPathPatterns("/**");
    }
}
