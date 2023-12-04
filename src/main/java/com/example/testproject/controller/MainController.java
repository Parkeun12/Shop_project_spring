package com.example.testproject.controller;

import com.example.testproject.entity.Product;
import com.example.testproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}