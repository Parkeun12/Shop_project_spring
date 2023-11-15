package com.example.testproject.controller;

import com.example.testproject.dto.UserFormDto;
import com.example.testproject.entity.Users;
import com.example.testproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
//    @Autowired
//    private UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/user/new")
    public String memberForm(UserFormDto userFormDto, Model model) {
        model.addAttribute("userFormDto", userFormDto);
        return "articles/join";
    }


//    @PostMapping(value="/user/new")
//    public String userForm(@Valid UserFormDto userFormDto, BindingResult bindingResult, Model model) {
//
//        if(bindingResult.hasErrors()) {
//            return "articles/join";
//        }
//
//        try {
//            Users user =Users.createUser(userFormDto, passwordEncoder);
////            userService.saveUser(user); //임의 주석
//            System.out.println("@@@@@ 입력한거 저장되는지확인하기" + user);
//        }catch(IllegalStateException e) {
//            model.addAttribute("errorMessage", e.getMessage());
//            return "articles/join";
//        }
//
//        return "redirect:/";
//    }

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
}
