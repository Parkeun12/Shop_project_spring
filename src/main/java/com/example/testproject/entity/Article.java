package com.example.testproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.ToString;
//=========== 회원가입 엔티티입니다 ==========
@ToString
@AllArgsConstructor
@Entity
public class Article {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 id 생성
    private Long i_d;

    @Column(name = "users_id")
    private String id;

    @Column(name = "users_pw")
    private String pw;

    @Column(name = "users_pw_check")
    private String pw_check;

    @Column(name = "users_name")
    private String name;

    @Column(name = "users_phone")
    private String phone;

    @Column(name = "users_email")
    private String email;

}
