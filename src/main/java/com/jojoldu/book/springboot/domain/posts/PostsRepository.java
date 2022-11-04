package com.jojoldu.book.springboot.domain.posts;

// 보통 ibatis나 MyBatis 에서 DAO라고 불리는 DB Layer 접근자
// 상속하면 기본적으로 CRUD 메서드가 자동으로 생성됨
/*
*   @Repository 추가할 필요가 없음
*   주의: Entity 클래스와 기본 Entity Repository는 함꼐 위치해야함
*
* */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    /*
    *   SpringDataJpa에서 제공하는 기본 메서드 만으로 해결 가능함, @Query가 가독성이 좋음
    * */
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
