package com.example.testproject.controller;

import com.example.testproject.Service.UserService;
import com.example.testproject.dto.UserFormDto;
import com.example.testproject.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private PasswordEncoder passwordEncoder;

    @GetMapping(value="/new")
    public String memberForm(UserFormDto userFormDto, Model model ) {
        model.addAttribute("userFormDto", userFormDto);
        return "articles/join";
    }


    @PostMapping(value="/new")
    public String userForm(@Valid UserFormDto userFormDto, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "articles/join";
        }

        try {
            User user = User.createUser(userFormDto, passwordEncoder);
            userService.saveUser(user);
            System.out.println("@@@@@ 입력한거 저장되는지확인하기" + user);
        }catch(IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "articles/join";
        }

        return "redirect:/";
    }
}
