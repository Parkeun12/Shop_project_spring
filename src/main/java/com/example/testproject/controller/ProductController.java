package com.example.testproject.controller;

import com.example.testproject.dto.ProductForm;
import com.example.testproject.entity.Product;
import com.example.testproject.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    public ProductRepository productRepository;

    // 상품 등록 페이지
    @GetMapping("/product/new")
    public String productSave(){

        return "articles/adminProduct";
    }

    // 상품 등록 (post) <pro 이름 변경 여부>
    @PostMapping("/product/create")
    public String createProduct(ProductForm form){
        log.info(form.toString());

        Product product = form.toEntity();
        log.info(form.toString());

        Product saved = productRepository.save(product);
        log.info(form.toString());

        return "";
    }
}
