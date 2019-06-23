package com.lanqiao.community.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author DeepSleeping
 * @date 2019/6/17 14:14
 * @description
 */
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private SessionInterception sessionInterception;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[]  excludes = new String[]{"/","/static/**","classpath:mapper/*.xml"};
        registry.addInterceptor(sessionInterception).addPathPatterns("/**").excludePathPatterns(excludes);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
