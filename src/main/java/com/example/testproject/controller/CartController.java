package com.example.testproject.controller;

import com.example.testproject.entity.Product;
import com.example.testproject.repository.CartRepository;
import com.example.testproject.dto.CartForm;
import com.example.testproject.entity.Cart;
import com.example.testproject.entity.Users;
import com.example.testproject.repository.ProductRepository;
import com.example.testproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Optional;

public class CartController {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/cart")
    public String createCart(CartForm form) {

        // 현재 로그인한 사용자의 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // currentUserId는 유저 로그인값을 가져옴(Users의 username)
        String currentUserId = authentication.getName();

        // 중복 체크
        if (!cartRepository.existsByUsersUsernameAndProductProductNum(currentUserId, form.getProductNum())) {
            // 사용자 정보 가져오기
            Optional<Users> currentUser = userRepository.findByUsername(currentUserId);

            // 사용자 정보가 존재하는 경우
            if (currentUser.isPresent()) {
                // CartForm에 현재 사용자의 ID를 설정
                form.setUserId(currentUser.get().getId());
                form.getProductNum();

                // CartForm을 Cart 엔티티로 변환
                Cart cart = form.toEntity();

                // 변환된 Cart를 저장
                Cart saved = cartRepository.save(cart);

                //아이디별로 뜨는 창이 달라야하기때문에 아이디값에 맞는 창 redirect
                return "redirect:/cart/" + saved.getUsers().getId();
            } else {
                return "redirect:/users/login"; // 로그인 페이지로 리다이렉트
            }
        } else {
            // 이미 장바구니에 들어있다면 상품상세페이지로 다시 redirect
            // 이미 장바구니에 담겨있는 상품입니다. < 팝업이나 alert추가 필요
            return "redirect:/mainshop/{productNum}";
        }
    }

    @GetMapping("/cart/{Id}")
    public String cart(Model model, @PathVariable Long id){

        // 전달받은 id 값으로 조회 > 데이터 가져오기
        ArrayList<Product> wishlistEntity = productRepository.findProductNameProductPriceByUserId(Id);

        //cart.mustache에 뿌려줘야함 추후 수정 필요 <wishlists, wishlistEntity>
        model.addAttribute("wishlists", wishlistEntity);

        return "articles/cart";
    }
}
