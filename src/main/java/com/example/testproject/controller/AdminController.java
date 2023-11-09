package com.example.testproject.controller;

import com.example.testproject.dto.AdminProductForm;
import com.example.testproject.entity.Product;
import com.example.testproject.entity.User_join;
import com.example.testproject.repository.AdminProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.extern.slf4j.Slf4j;

import java.io.Console;

@Slf4j
@Controller
public class AdminController {
    @Autowired
    public AdminProductRepository adminProductRepository;

    @GetMapping("/articles/adminProduct")
    public String adminProductPage(){
        return "articles/adminProduct";
    }

    @GetMapping("/articles/adminProductList")
    public String adminProductListPage(){
        return "articles/adminProductList";
    }

    @PostMapping("/articles/create")
    public String createProduct(AdminProductForm form){
        // DTO > Entity로 변환
        Product product = form.toEntity();
        Product saved = adminProductRepository.save(product);
        log.info(form.toString());
        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);
        Product productEntity = adminProductRepository.findById(id).orElse(null);
        model.addAttribute("user_joinEntity", productEntity);
        return "articles/show";
    }
}