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

    @GetMapping(value="/new")
    public String memberForm(UserFormDto userFormDto, Model model) {
        model.addAttribute("userFormDto", userFormDto);
        return "articles/join";
    }


    @PostMapping(value="/new")
    public String userForm(@Valid UserFormDto userFormDto, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "articles/join";
        }

        try {
            Users user = Users.createUser(userFormDto, passwordEncoder);
//            userService.saveUsers(user);
        }catch(IllegalStateException e) {
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
