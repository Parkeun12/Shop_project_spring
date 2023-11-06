package com.example.testproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

//    @Autowired
//    private MainRepository mainRepository;

    @GetMapping("/mainshop")
    public String MainShop_page(){
        return "/articles/Main_page";
    }
}