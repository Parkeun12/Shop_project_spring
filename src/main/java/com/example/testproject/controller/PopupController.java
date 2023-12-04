package com.example.testproject.controller;

import com.example.testproject.entity.Product;
import com.example.testproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PopupController {

    @Autowired
    public ProductRepository productRepository;

    @GetMapping("/mainshop/payment_popup/{productNum}")
    public String MainShop_popup1(@PathVariable Long productNum, Model model){

        log.info("productNum = " + productNum);

        Product productEntity = productRepository.findById(productNum).orElse(null);

        model.addAttribute("paymentPopup", productEntity);

        return "articles/payment_popup";
    }

}
