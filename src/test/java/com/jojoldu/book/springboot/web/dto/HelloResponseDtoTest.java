package com.jojoldu.book.springboot.web.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        /*
         * assertThat
         *   assertj라는 테스트 검증 라이브러리의 검증 메서드임
         *   검증하고 싶은 대상을 메서드 인자로 받음
         *   메서드 체이닝이 지원되어 isEqualTo와 같이 메서드를 이어서 사용할 수 있음
         *  isEqualTo
         *   assertj와 동등 비교 메서드임
         *   같을 때만 성공함
         * JUnit 대비 assertj 장점
         *   CoreMatchers 와 달리 추가적으로 라이브러리가 필요하지 않음
         *      -> JUnit의 assertThat을 쓰면 is()와 같이 CoreMatchers 라이브러리가 필요함
         *   자동완성이 좀 더 확실하게 지원됨
         *      -> IDE에서는 CoreMatchers와 같은 Matcher 라이브러리의 자동완성 지원이 약함
         *
         * */
    }


}