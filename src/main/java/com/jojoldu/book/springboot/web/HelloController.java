package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *       Controller를 Json으로 반환하는 컨트롤러로 만들어줌
 *       예전에는 @ResponseBody를 각 메서드마다 선언했던 것을 한번에 사용할 수 있게 해줌
 * */
@RestController
public class HelloController {
    /*
     *   HTTP Method Get의 요청을 받을 수 있는 API 만들어줌
     *   예전에는 @RequestMapping(method = RequestMethod.GET) 으로 사용함
     * */
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /*
    *   @RequestParam
    *       외부에서 API로 넘긴 파라미터를 가져옴
    *       외부에서 name 이란 이름으로 넘긴 파라미터를 메서드 파라미터 name에 저장하게 됨
    * */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(
            @RequestParam("name") String name
            , @RequestParam("amount") int amount
    ) {
        return new HelloResponseDto(name, amount);
    }

}
