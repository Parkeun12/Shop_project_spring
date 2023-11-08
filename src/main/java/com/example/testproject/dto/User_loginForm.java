package com.example.testproject.dto;

import com.example.testproject.entity.User_login;
import lombok.AllArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@ToString
public class User_loginForm {

        private String id;
        private String pw;
        //전송받은 아이디와 비밀번호를 필드에 저장하는 생성자 추가

        public User_login toEntity() {
            return new User_login(null, id, pw);
        }

}
