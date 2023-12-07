package com.example.testproject.controller;

import com.example.testproject.entity.Product;
import com.example.testproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/mainshop")
    public String MainShop_page(Model model){

        ArrayList<Product> productEntityList = productRepository.findAll();

        model.addAttribute("mainProduct", productEntityList);

        return "/articles/Main_page";
    }
    @GetMapping(value = "/mainshop_user")
    public String MainShop_user(Model model){

        ArrayList<Product> productEntityList = productRepository.findAll();

        model.addAttribute("mainProduct", productEntityList);

        return "/articles/Main_page_user";
    }

    @GetMapping("/mainshop/{productNum}")
    public String ProductMorePage(@PathVariable Long productNum, Model model)
    {
        // @PathVariable로 전달받은 prodcutNum값으로 조회 > 데이터 가져오기
        Product productEntity = productRepository.findById(productNum).orElse(null);
        model.addAttribute("productMore", productEntity);
        return "/articles/productMore";
    }
}