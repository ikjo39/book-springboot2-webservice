package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
*   BaseTimeEntity -> 모든 Entity의 상위 클래스가 되어 Entity들의 created, modified 자동 관리
* */
@Getter
@MappedSuperclass   // JPA Entity 클래스들이 BaseTimeEntity 상속할 경우 필드들도 칼럼으로 인식함
@EntityListeners(AuditingEntityListener.class)  // Auditing 기술 포함
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
