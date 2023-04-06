package idusw.springboot.boardthymeleaf.controller;

import idusw.springboot.boardthymeleaf.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
//@RequestMapping("/api")
public class HomeController {    //open-api 작성할 때 많이 사용함, 바로 response-body 반환함
    @Autowired
    MemoService memoService;    //MemoServie 인터페이스의 구현체를 필드 주입

    @GetMapping("/")
    public String goHome() {
        return "index";
    }
}