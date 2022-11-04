package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.SecurityConfig;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/*
*   테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
*   SpringRunner 라는 스프링 실행자를 사용함
*   스프링 부트 테스트와 JUnit 사이의 연결자 역할을 함
* */
@RunWith(SpringRunner.class)
/*
*   여러 스프링 테스트 어노테이션 중 Web에 집중할 수 있는 어노테이션
*   @Controller, @ControllerAdvice 등을 사용 가능
*   단, @Service, @Component, @Repository 등은 사용 불가능 - 컨트롤러만 사용 가능
* */
@WebMvcTest(controllers = HelloController.class,
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
    }
)
public class HelloControllerTest extends TestCase {

    /*
    *   스프링이 관리하는 빈(@Bean)을 주입 받음
    * */
    @Autowired
    /*
     *  웹 API를 테스트할 때 사용함
     *  스프링 MVC 테스트의 시작점임
     *  HTTP GET, POST 등에 대한 API를 테스트 할 수 있음
     * */
    private MockMvc mvc;

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        // given
        String hello = "hello";
        // when
        // then
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                /*
                *   결과 검증, HTTP Header Status 검증
                *   우리가 흔히 아는 200, 404, 500 등 상태 검증
                *   Ok, 200 인지 검증
                * */
                .andExpect(content().string(hello));
                /*
                *   결과 검증
                *   응답 본문의 내용을 검증
                *   Controller에서 "hello"를 리턴하기 떄문에 이 값이 맞는지 검증
                * */
    }

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
        /*
        *   param
        *       - API 테스트할 때 사용될 요청 파라미터를 설정
        *       - 단, 값은 String만 허용됨
        *       - 그래서 숫자/날짜 데이터도 문자열로 변경해야함
        *
        *   jsonPath
        *       - JSON 응답값을 필드별로 검증할 수 있는 메서드임
        *       - $를 기준으로 필드명을 명시함
        *       - 여기서는 name과 amont를 검증하니 $.name, $.amount로 검증함
        * */
    }
}