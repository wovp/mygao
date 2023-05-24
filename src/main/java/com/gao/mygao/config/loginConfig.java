package com.gao.mygao.config;

import com.gao.mygao.interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: loginConfig
 * Package: com.gao.mygao.config
 * Description:
 * Author: my
 * Creat: 2023/4/22 20:30
 * @author 11
 */
@Configuration
public class loginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new loginInterceptor());
        registration.addPathPatterns("/home");

    }
}
