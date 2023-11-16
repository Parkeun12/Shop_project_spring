
package com.example.testproject.dto;

import com.example.testproject.entity.Role;
import com.example.testproject.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@AllArgsConstructor
@Getter
@Setter
public class UserFormDto {

    private Long id;
    private String userId;

//    @NotEmpty(message="비밀번호는 필수 입력값입니다.")
//    @Length(min=8, max=16, message="비밀번호는 8자이상, 16자 이하로 입력해주세요.")
    private String pw;


    private String pwCheck;

//    @NotEmpty(message="이름은 필수 입력값입니다.")
    private String name;

//    @NotEmpty(message="전화번호는 필수 입력값입니다.")
    private String phone;

//    @NotEmpty(message="이메일은 필수 입력값입니다.")
//    @Email(message="이메일 형식으로 입력해주세요.")
    private String email;

    private Role role;
        public Users toEntity() {
        return new Users(id, userId, pw, pwCheck, name, phone, email, role);
    }
}