package com.example.testproject.controller;

import com.example.testproject.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    @GetMapping(value = "/login")
    public String loginUser() {
        return "articles/login";
    }

    @PostMapping(value = "/login")
    public String Login(){
        return "redirect:/"; //성공 시 메인페이지로 리다이렉트
    }

    //    로그인 에러 페이지
    @GetMapping(value = "/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
        return "articles/login";
    }
}
