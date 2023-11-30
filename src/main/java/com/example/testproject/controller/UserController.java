package com.example.testproject.controller;

import com.example.testproject.Service.UserService;
import com.example.testproject.dto.UserFormDto;
import com.example.testproject.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
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
    public String userForm(UserFormDto userFormDto) {
        return "articles/join";
    }
    @PostMapping(value = "/new")
    public String newUser(@Valid UserFormDto userFormDto , BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "articles/join";
        }

        if(!userFormDto.getPassword().equals(userFormDto.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect","패스워드가 일치하지 않습니다.");
            return "articles/join";
        }

        try {
            userService.create(userFormDto.getUsername(),userFormDto.getPassword(),userFormDto.getPassword2(),userFormDto.getName(),userFormDto.getEmail(),userFormDto.getPhone());

        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("joinFailed", "이미 등록된 사용자입니다.");
            return "articles/join";
        } catch (Exception e) {
            //그 외 모든 에러
            e.printStackTrace(); //콘솔에 에러메시지
            bindingResult.reject("joinFailed", "예상치 못한 에러가 발생했습니다.");
        }

        return "redirect:/mainshop";
    }

//    로그인 데이터 보내기
    @GetMapping(value = "/login")
    public String loginUser(String username) {
        log.info(username);
        return "articles/login";
    }

//  로그인 post는 시큐리티가 처리함(인증)
    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/mainshop";
    }

}
