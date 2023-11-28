package com.example.testproject.entity;

import lombok.Getter;

@Getter
//관리자와 일반 유저 구분
public enum Role {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    Role(String value){
        this.value = value;
    }

    private String value;

}