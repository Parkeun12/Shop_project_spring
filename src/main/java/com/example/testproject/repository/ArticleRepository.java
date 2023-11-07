package com.example.testproject.repository;

import com.example.testproject.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

//================ 회원가입 리포지토리입니다 ==============
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
