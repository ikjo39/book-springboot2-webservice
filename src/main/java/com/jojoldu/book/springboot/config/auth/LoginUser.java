package com.jojoldu.book.springboot.config.auth;

/*
*   IndexController 에서 세션값을 가져오는 부분 개선
*   SessionUser user = (SessionUser) httpsession.getAttribute("user");
*
*   index 메서드 외에 다른 컨트롤러와 메서드에서 세션값이 필요하면 그떄마다 직접 세션에서 값을 가져와야함
*   -> 메서드 인자로 세션값을 받을 수 있도록 변경
* */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}

/*
* @Target(ElementType.PARAMETER)
* - 이 어노테이션이 생성될 수 있는 위치를 지정
*   PARAMETER 로 지정했으니 메서드의 파라미터로 선언된 객체에서만 사용할 수 있음
*   이 외에도 클래스 선언문에 슬 수 있는 TYPE 등이 음
*
* @interface
* - 이 파일을 어노테이션 클래스로 지정함
 * */