package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    /*
    *     private final HttpSession httpSession;
    * // CustomOAuth2UserService에서 로그인 성공시 세션에 SessionUser를 저장함
    *
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
    * */
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        // 가져온 결과를 posts로 index.mustache로 전달함
        model.addAttribute("posts", postsService.findAllDesc());

        // 세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 화면이 보이게 됨
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
