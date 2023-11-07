package com.example.testproject.controller;

import com.example.testproject.dto.ArticleForm;
import com.example.testproject.entity.Article;
import com.example.testproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//수정
@Controller
public class FirstController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/join")
    public String niceToMeetYou(){
        return "/articles/join";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());
        //1.dto를 entity로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());
        //2. repository로 엔티티를 디비에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "";
    }
}
