package idusw.springboot.boardthymeleaf.controller;

import idusw.springboot.boardthymeleaf.domain.Memo;
import idusw.springboot.boardthymeleaf.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemoController {
    // 생성자 주입 (Constructor DI)
    MemoService memoService;
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/init")
    public String initialize(Model model) {
        List<Memo> result = new ArrayList<>();
        result = memoService.initialize();
        model.addAttribute("result", result);
        return "list";
    }

    @GetMapping("/memo")
    public String getList(Model model) {
        List<Memo> result = new ArrayList<>();
        result = memoService.readList();
        model.addAttribute("result", result);
        return "list";
    }

    @GetMapping("/memo/{mno}")
    public String getList(@PathVariable("mno") Long mno, Model model) {
        Memo result = new Memo();
        Memo m = new Memo();
        m.setMno(mno);
        result = memoService.read(m);
        model.addAttribute("result", result);
        return "one";
    }
}
