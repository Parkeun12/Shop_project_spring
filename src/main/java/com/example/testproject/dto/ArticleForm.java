package com.example.testproject.dto;

import com.example.testproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;
//========= 회원가입 dto입니다 ==========
@AllArgsConstructor
@ToString
public class ArticleForm {
    private String id;
    private String pw;
    private String pw_check;
    private String name;
    private String phone;
    private String email;

    public Article toEntity() {
        return new Article(null, id, pw, pw_check, name, phone, email);
    }
}
