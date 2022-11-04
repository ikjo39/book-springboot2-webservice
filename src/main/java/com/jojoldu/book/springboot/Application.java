package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
*   항상 서버에 톰캣을 설치할 필요가 없어짐
*   스프링 부트에서는 내장 WAS를 사용하는 것을 권장함.
*   - 언제 어디서나 같은 환경에서 스프링 부트를 배포 할 수 있음
* */

//@EnableJpaAuditing  // JPA Auditing 활성화 - Test를 위해 분리
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
