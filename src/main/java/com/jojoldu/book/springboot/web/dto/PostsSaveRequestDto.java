package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}

/*  절대로 Entity 클래스를 Request/Response 클래스로 사용하면 안됨
    Entity는 데이터베이스와 맞닿은 핵심 클래스임
    화면 변경은 사소하지만 이때매 Entity 클래스를 변경하는건 리스크가 크다
    View Layer와 DB Layer의 역할 분리를 철저하게 하는 것이 좋음
    - Controller 에서 결괏값으로 여러 테이블을 조인해서 줘야 할 경우가 빈번함
    - 꼭, Controller에서 쓸 DTO는 분리해서 사용해야함
*
* */