package com.example.testproject.controller;

import com.example.testproject.dto.ArticleForm;
import com.example.testproject.entity.Article;
import com.example.testproject.repository.ArticleRepository;
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
public class FirstController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/join")
    public String niceToMeetYou(){
        return "/articles/join";
    }
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
      log.info(form.toString());
        //1.dto를 entity로 변환
        Article article = form.toEntity();
        log.info(article.toString());
        //2. repository로 엔티티를 디비에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "";
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "articles/show";
    }
}
