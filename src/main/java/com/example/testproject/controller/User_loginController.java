package com.example.testproject.controller;

import com.example.testproject.dto.User_loginForm;
import com.example.testproject.entity.User_login;
import com.example.testproject.repository.User_loginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//========= 로그인 컨트롤러입니다 ===========

//수정
@Controller
@Slf4j
@RequiredArgsConstructor // service 사용하기 위해서 넣은 어노테이션
public class User_loginController {

    @Autowired
    private User_loginRepository user_loginRepository;

    @GetMapping("/logs/login")
    public String loginPage(){
        return "/logs/login";
    }

    @PostMapping("/logs/create")
    public String createlogin(User_loginForm form){
        log.info(form.toString());

        User_login user_login = form.toEntity();
        log.info(user_login.toString());

        User_login saved = user_loginRepository.save(user_login);
        log.info(form.toString());
        return "";
    }
//    public String login(@ModelAttribute User_login user_login, HttpSession session){
//        User_login loginResult = UserService.login(user_login);
//        if (loginResult != null){
//            //login 성공
//            session.setAttribute("Id",loginResult.getId());
//            return "/articles/Main_page";
//        }else{
//            return "/logs/login";
//        }
//    }
    @GetMapping("/logs/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);
        User_login user_loginEntity = user_loginRepository.findById(id).orElse(null);
        model.addAttribute("user_loginEntity", user_loginEntity);
        return "/logs/show";
    }
}
