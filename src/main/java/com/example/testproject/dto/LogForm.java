package com.example.testproject.dto;


import com.example.testproject.entity.Article;
import com.example.testproject.entity.Log;

public class LogForm {
    private String id;
    private String pw;
    //전송받은 아이디와 비밀번호를 필드에 저장하는 생성자 추가
    public LogForm(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
    //데이터를 잘 받았는지 확인할 toString() 메소드 추가
    @Override
    public String toString() {
        return "LogForm{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
    public Log toEntity() {
        return new Log(null, id, pw);
    }

}
