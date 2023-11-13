package com.example.testproject.controller;

import com.example.testproject.entity.Product;
import com.example.testproject.entity.User_join;
import com.example.testproject.repository.CartRepository;
import com.example.testproject.repository.User_joinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j

public class CartController {
    @Autowired
    public CartRepository cartRepository;
    public User_joinRepository user_joinRepository;


    // 장바구니에 물건 넣기
    @PostMapping("/user/cart/{id}/{itemId}")
    public String addCart_item(@PathVariable("id") Integer id, @PathVariable("product") Integer itemId, int amount) {

        User_join user_join = user_joinRepository.findUser_join(id);
        Product product = cartRepository.itemView(itemId);

        cartRepository.addCart(user_join, product, amount);

        return "redirect:/item/view/{itemId}";
    }
}

