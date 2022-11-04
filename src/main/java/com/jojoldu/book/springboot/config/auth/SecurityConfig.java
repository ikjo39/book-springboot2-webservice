package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  // Spring Security 설정들을 활성화 시켜줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//  http.csrf().disable().headers().frameOptions().disable() h2-console을 이용하기 위해 비활성화
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**"
                        , "/js/**", "/h2-console/**")
                .permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

    }
}
/*
 *   .authorizeRequests() - URL 별 권한 관리를 설정하는 옵션의 시작점 - antMatchers 이용 위함
 *   .antMatchers() - 권한 관리 대상 지정, URL, HTTP 매서드별 관리 가능, USER 권한 가진 사람만 가능
 *   .anyRequest().authenticated() - 나머지는 인증된 사람만 보도록 함
 *   .oauth2Login() - OAuth2 로그인 기능의 설정 진입점
 *   .userInfoEndpoint() - 로그인 성공 이후 사용자 정보를 가져올 떄의 설정 담당
 *   .userService(service) - 후속 조치를 진행할 Service Interface의 구현체를 등록함
 *                         - 리소스 서버에서 사용자 정보를 가져온 상테에서 추가로 진행하고자 하는 긴으 명시 가능
 * */