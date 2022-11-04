package com.jojoldu.book.springboot.config;

/*
*   LoginUserArgumentResolver가 스프링에서 인식 될 수 있도록 WbeMvnConfigurer에 추가
*   - HandlerMethodArgumentResolver는 항상 WebMvnConfigurer의 addArgumentResolvers()를 통해 추가해야함
* */

import com.jojoldu.book.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
