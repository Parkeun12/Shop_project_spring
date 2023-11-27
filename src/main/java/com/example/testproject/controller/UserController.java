package com.example.testproject.controller;

import com.example.testproject.Service.UserService;
import com.example.testproject.dto.UserFormDto;
import com.example.testproject.entity.Users;
import com.example.testproject.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/new")
    public String userForm(UserFormDto userFormDto ,Model model) {
        model.addAttribute("userFormDto", userFormDto);
        return "articles/join";
    }
//    검증하려는 객체의 앞에 @Valid 어노테이션을 선언하고, 파라미터로 bindingResult 객체를 추가한다.
//    검사 후 결과는 bindingResult에 담아준다. bindingResult.hasErrors()를 호출하여 에러가 있으면 회원가입 페이지로 이동한다.
//    회원가입 시 중복 회원 가입 예외가 발생하면 에러 메시지를 뷰로 전달한다.
//    유효하지 않은 회원 가입 정보를 입력 후 서버로 전송하면 해당 이유를 화면에서 보여준다.
    @PostMapping(value = "new")
    public String newUser(@Valid UserFormDto userFormDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "articles/join";
        }
        try {
            Users user = Users.createUsers(userFormDto, passwordEncoder);
            userService.saveUsers(user);
        } catch (IllegalStateException e) {
        model.addAttribute("errorMessage", e.getMessage());
            return "articles/join";
        }
        return "redirect:/";
    }

//    로그인 데이터 보내기
    @GetMapping(value = "/login")
    public String loginUser() {
        return "articles/login";
    }
//    로그인 에러 페이지
    @GetMapping(value = "/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
        return "articles/login";
    }
}
