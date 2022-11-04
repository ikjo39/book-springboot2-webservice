package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 롬복 어노테이션 (필수 X)
@NoArgsConstructor // 롬복 어노테이션 (필수 X)
@Entity     // JPA의 어노테이션
/*
*   테이블과 링크될 클래스임을 나타냄
*   기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름으로 매칭
* */
public class Posts extends BaseTimeEntity {

    @Id // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙 2.0에서는 GenerationType.IDENTITY를 추가해여 자동 증가
    private Long id;

    @Column(length = 500, nullable = false) // 기본값외에 추가 옵션이 있을때, size늘림
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
/*
*       Entity 클래스에서는 절대 Setter 메서드를 만들지 않음
*       대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼수 있는 메서드를 추가함
* */