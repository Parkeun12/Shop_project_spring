package com.example.testproject.controller;

import com.example.testproject.dto.User_joinForm;
import com.example.testproject.entity.User_join;
import com.example.testproject.repository.User_joinRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//========= 회원가입 컨트롤러입니다 ===========

//수정
@Controller
@Slf4j
public class User_joinController {

    @Autowired
    private User_joinRepository user_joinRepository;

    @GetMapping("/articles/join")
    public String joinPage(){
        return "/articles/join";
    }

    @PostMapping("/articles/create")
    public String createJoin(User_joinForm form){
        log.info(form.toString());

        User_join user_join = form.toEntity();
        log.info(user_join.toString());

        User_join saved = user_joinRepository.save(user_join);
        log.info(form.toString());
        return "";
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);
        User_join user_joinEntity = user_joinRepository.findById(id).orElse(null);
        model.addAttribute("user_joinEntity", user_joinEntity);
        return "articles/show";
    }
}
