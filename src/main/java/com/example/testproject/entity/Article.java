package com.example.testproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private Long i_d;
    @Column
    private String id;
    @Column
    private String pw;
    //Article 생성자 추가
    public Article(Long i_d, String id, String pw) {
        this.i_d = i_d;
        this.id = id;
        this.pw = pw;
    }
    //toString() 메소드 추가
    @Override
    public String toString() {
        return "Article{" +
                "i_d=" + i_d +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
