
package com.example.testproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;


@ToString
@AllArgsConstructor
@Getter
@Setter
public class UserFormDto {

    private Long id;

    @NotBlank(message="아이디는 필수 입력값입니다.")
    @Length(min=4, max=16, message="아이디는 4자이상, 16자 이하로 입력해주세요.")
    private String username;

    @NotEmpty(message="비밀번호는 필수 입력값입니다.")
    @Length(min=8, max=16, message="비밀번호는 8자이상, 16자 이하로 입력해주세요.")
    private String password;

    @NotEmpty(message="비밀번호는 필수 입력값입니다.")
    @Length(min=8, max=16, message="비밀번호는 8자이상, 16자 이하로 입력해주세요.")
    private String password2;

    @NotEmpty(message="이름은 필수 입력값입니다.")
    private String name;

    @NotEmpty(message="전화번호는 필수 입력값입니다.")
    private String phone;

    @NotEmpty(message="이메일은 필수 입력값입니다.")
    private String email;

//    private UserRole role;

}