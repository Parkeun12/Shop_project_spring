package com.example.testproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/articles/Main")
    public String niceToMeetYou(){
        return "/articles/Main_page";
    }
}
