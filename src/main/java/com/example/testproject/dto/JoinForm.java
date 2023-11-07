package com.example.testproject.dto;

import com.example.testproject.entity.Join;

public class JoinForm {
    private String id;
    private String pw;
    private String pw_check;
    private String name;
    private String phone;
    private String email;

    @Override
    public String toString() {
        return "ArticleForm{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", pw_check='" + pw_check + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    //전송받은 아이디,비번 등을 필드에 저장하는 생성자 추가
    public JoinForm(String id, String pw, String pw_check, String name, String phone, String email) {
        this.id = id;
        this.pw = pw;
        this.pw_check = pw_check;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Join toEntity() {
        return new Join(null, id, pw, pw_check, name, phone, email);
    }
}
