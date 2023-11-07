package com.example.testproject.controller;

import com.example.testproject.dto.JoinForm;
import com.example.testproject.entity.Join;
import com.example.testproject.repository.JoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {
    @Autowired
    private JoinRepository joinRepository;

    @GetMapping("/articles/join")
    public String niceToMeetYou(){
        return "/articles/join";
    }
    @PostMapping("/articles/create")
    public String createArticle(JoinForm form){
        System.out.println(form.toString());
        //1.dto를 entity로 변환
        Join join = form.toEntity();
        System.out.println(join.toString());
        //2. repository로 엔티티를 디비에 저장
        Join saved = joinRepository.save(join);
        System.out.println(saved.toString());
        return "";
    }
}
