package com.example.testproject.entity;

import jakarta.persistence.*;

@Entity
public class Article {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 id 생성
    private Long i_d;
    @Column
    private String id;
    @Column
    private String pw;
    @Column
    private String pw_check;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String email;

    //Article 생성자 추가
    public Article(Long i_d, String id, String pw, String pw_check, String name, String phone, String email) {
        this.i_d = i_d;
        this.id = id;
        this.pw = pw;
        this.pw_check = pw_check;
        this.name = name;
        this.phone = phone;
        this.email = email;

    }

    @Override
    public String toString() {
        return "Article{" +
                "i_d=" + i_d +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", pw_check='" + pw_check + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}