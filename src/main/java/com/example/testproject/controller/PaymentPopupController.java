package com.example.testproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentPopupController {

    @GetMapping("/payment_popup")
    public String MainShop_page(){
        return "/articles/payment_popup";
    }
}
