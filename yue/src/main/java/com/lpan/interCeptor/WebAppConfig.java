package com.lpan.interCeptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 将需要验证的方法，按/needValidate/a/p 的方式输入地址就行
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/needValidate/**");
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**");
    }
}