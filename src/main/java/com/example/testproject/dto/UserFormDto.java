package com.example.testproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFormDto {
    private String users_id;
    private String pw;
    private String pw_check;
    private String name;
    private String phone;
    private String email;
}
