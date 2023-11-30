
package com.example.testproject.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //회원은 유저아이디를 통해 유일하게 구분해야 하기 때문에, 동일한 값이 데이터베이스에 들어올 수 없도록 unique 속성을 지정함
    @Column(name = "users_id", unique = true)
    private String username;

    @Column(name = "users_pw")
    private String password;

    @Column(name = "users_pw_check")
    private String password2;

    @Column(name = "users_name")
    private String name;

    @Column(name = "users_phone")
    private String phone;

    @Column(name = "users_email")
    private String email;

    /*
     * 자바의 Enum타입을 엔티티의 속성을 지정할 수 있다.
     * Enum을 사용할 때 기본적으로 순서가 저장되는데,
     * enum의 순서가 바뀔 경우, 문제가 발생할 수 있으므로 "EnumType.STRING" 옵션을 사용해서 String으로 저장하기를 권장
     * */
//    @Enumerated(EnumType.STRING)
    private String role;

}