package com.example.testproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Entity
public class User_login {
    @jakarta.persistence.Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 id 생성
    private Long userJoinId;

    @Column(name = "users_id")
    private String Id;

    @Column(name = "users_pw")
    private String Pw;
}
