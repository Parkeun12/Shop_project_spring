package com.example.testproject.controller;

import com.example.testproject.dto.WishlistForm;
import com.example.testproject.entity.Product;
import com.example.testproject.entity.Users;
import com.example.testproject.entity.Wishlist;
import com.example.testproject.repository.UserRepository;
import com.example.testproject.repository.WishlistRepository;
import com.example.testproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class WishlistController {

    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;


    // 관심상품 리스트 보여주는 매핑
    @GetMapping("/wishlist/{Id}")
    public String wishlist(Model model, @PathVariable Long Id) {

        // 전달받은 id 값으로 조회 > 데이터 가져오기
        ArrayList<Product> wishlistEntity = productRepository.findWishlistIdProductNameProductPriceByUserId(Id);

        model.addAttribute("wishlists", wishlistEntity);

        // 현재 로그인한 사용자의 관심상품 가져오기
        return "articles/wishlist";
    }

    @PostMapping("/wishlist")
    public String createWishlist(WishlistForm form) {
        // 현재 로그인한 사용자의 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserId = authentication.getName();

        // 중복 체크
        if (!wishlistRepository.existsByUsersUsernameAndProductProductNum(currentUserId, form.getProductNum())) {
            // 사용자 정보 가져오기
            Optional<Users> currentUser = userRepository.findByUsername(currentUserId);

            // 사용자 정보가 존재하는 경우
            if (currentUser.isPresent()) {
                // WishlistForm에 현재 사용자의 ID를 설정
                form.setUserId(currentUser.get().getId());
                form.getProductNum();

                // WishlistForm을 Wishlist 엔티티로 변환
                Wishlist wishlist = form.toEntity();

                // 변환된 Wishlist를 저장
                Wishlist saved = wishlistRepository.save(wishlist);

                return "redirect:/wishlist/" + saved.getUsers().getId();
            } else {
                return "redirect:/users/login"; // 로그인 페이지로 리다이렉트
            }
        } else {
            return "redirect:/mainshop";
        }
    }

    @GetMapping("/wishlist/{productNum}/delete")
    public String deleteWishlistItem(@PathVariable Long productNum, WishlistForm form) {
        String currentUserId = getCurrentUserId();

        Optional<Users> currentUser = userRepository.findByUsername(currentUserId);

        if (currentUser.isPresent()) {
            form.setUserId(currentUser.get().getId());
            // WishlistRepository에서 해당하는 Wishlist를 찾아서 삭제
            Wishlist DeleteTarget = wishlistRepository.findByUsersAndProductProductNum(currentUser.get().getId(), productNum).orElse(null);
            // 여기에서 터짐 delete안됨
            wishlistRepository.delete(DeleteTarget);
        } else {
            return "redirect:/mainshop";
        }

        return "redirect:/wishlist/" + currentUserId;
    }


    private String getCurrentUserId() {
        // 현재 로그인한 사용자의 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}