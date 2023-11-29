
package com.example.testproject.entity;

import com.example.testproject.dto.UserFormDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")

@ToString
@Entity
@Getter
@Setter
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //회원은 유저아이디를 통해 유일하게 구분해야 하기 때문에, 동일한 값이 데이터베이스에 들어올 수 없도록 unique 속성을 지정함
    @Column(name = "users_id", unique = true)
    private String userId;

    @Column(name = "users_pw")
    private String pw;

    @Column(name = "users_pw_check")
    private String pwCheck;

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
    @Enumerated(EnumType.STRING)
    private Role role;

    //Wishlist와 양방향매핑
    @OneToMany(mappedBy = "users")
    private List<Wishlist> wishlists = new ArrayList<>();


    //Member 엔티티를 생성하는 메소드, Member 엔티티에 회원을 생성하는 메소드를 만들어서 관리를 한다면 코드가 변경되더라도 한 군데만 수정하면 되는 이점이 있음
    //스프링 시큐리티 설정 클래스에 등록한 BCryPaswordEncoder Bean을 파라미터로 넘겨서 비밀번호를 암호화함
    public static Users createUsers(UserFormDto userFormDto, PasswordEncoder passwordEncoder) {
        Users user = new Users();

        user.setUserId(userFormDto.getUserId());
        user.setName(userFormDto.getName());
        user.setEmail(userFormDto.getEmail());
        user.setPhone(userFormDto.getPhone());
        user.setPwCheck(userFormDto.getPwCheck());

        // 스프링 시큐리티 설정을 클래스에 등록한 BCryptPassword Bean을 파라미터로 넘겨서 비밀번호를 암호화
        String password = passwordEncoder.encode(userFormDto.getPw());
        user.setPw(password);

        //관리자로 가길 원하면 이 줄 수정
        //role.admin으로 변경하면 가능
//        user.setRole(Role.USER);

        return user;
    }
}