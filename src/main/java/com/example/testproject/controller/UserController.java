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


@Controller
@Slf4j
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

//    @GetMapping("user/join")
//    public String userForm(UserFormDto userFormDto, Model model) {
//        model.addAttribute("userFormDto", userFormDto);
//        return "articles/join";
//    }
//    회원가입 성공하면 메인 페이지로 리다이렉트
//    @PostMapping(value="/new")
//    public String userForm(UserFormDto userFormDto) {
//        Users user = Users.createUser(userFormDto, passwordEncoder);
//        userService.saveUser(user);
//        return "redirect:/mainshop";
//    }
//    검증하려는 객체의 앞에 @Valid 어노테이션을 선언하고, 파라미터로 bindingResult 객체를 추가한다.
//    검사 후 결과는 bindingResult에 담아준다. bindingResult.hasErrors()를 호출하여 에러가 있으면 회원가입 페이지로 이동한다.
//    회원가입 시 중복 회원 가입 예외가 발생하면 에러 메시지를 뷰로 전달한다.
//    유효하지 않은 회원 가입 정보를 입력 후 서버로 전송하면 해당 이유를 화면에서 보여준다.
    @PostMapping(value = "/new")
    public String newUser(@Valid UserFormDto userFormDto,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "articles/join";
        }

        try {
            Users user = Users.createUser(userFormDto, passwordEncoder);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "articles/join";
        }

        return "redirect:/";
    }


    //회원가입 데이터 보내기
    @GetMapping("/user/join")
    public String joinPage(){
        return "/articles/join";
    }

    @PostMapping("/user/create")
    public String createJoin(UserFormDto form){
        log.info(form.toString());

        Users user = form.toEntity();
        log.info(user.toString());

        Users saved = userRepository.save(user);
        log.info(form.toString());
        return "";
    }
    //로그인 데이터 보내기
//    @GetMapping("/user/login")
//    public String LoginPage(){
//        return "/articles/login";
//    }
//
//    @PostMapping("/user/lg")
//    public String createLogin(UserFormDto form){
//        log.info(form.toString());
//
//        Users user = form.toEntity();
//        log.info(user.toString());
//
//        Users saved = userRepository.save(user);
//        log.info(form.toString());
//        return "";
//    }
}
