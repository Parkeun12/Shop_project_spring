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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String wishlist(Model model) {
//        // 현재 로그인한 사용자의 ID를 가져온다
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUserId = authentication.getName();

        ArrayList<Product> productWishlist = productRepository.findProductNameProductPrice();

        model.addAttribute("wishlists", productWishlist);


        // 현재 로그인한 사용자의 관심상품 가져오기
//        model.addAttribute("wishlists", wishlistRepository.findByUsersUserId(currentUserId));
        return "articles/wishlist";
    }


    @PostMapping("/wishlist")
    // @RequestParam은 HTTP 요청에서 파라미터 값을 가져오기 위해 사용
    public String createWishlist(WishlistForm form) {
// 현재 로그인한 사용자의 ID를 가져온다
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserId = authentication.getName();

// 현재 로그인한 사용자의 정보 가져오기
        Optional<Users> currentUser = userRepository.findByUsername(currentUserId);

        if (currentUser != null) {
            // WishlistForm에 현재 사용자의 ID를 설정
            form.setUserId(currentUser.get().getId());

            // Product의 productNum을 설정 << 이거 변경해야할 것 같음 지금 1만 받아오고있음 디버깅시
            // 해결! input type으로 설정되어있었던 버튼을 submit으로 변경, value = {{productNum}}
            // 변경했지만 여전히 적용이 안되는 문제 발생 > name = "productNum"을 추가해 문제 해결함, 정상적으로 productNum값이 받아와짐
            // product의 id값을 가져오려면 굳이 form데이터를 안받아와도 됨 간단하게 처리 가능O
            form.getProductNum();

            // WishlistForm을 Wishlist 엔티티로 변환
            Wishlist wishlist = form.toEntity();

            // 변환된 Wishlist를 저장하고 저장된 Wishlist의 사용자 ID를 이용하여 리다이렉트 경로를 생성
            Wishlist saved = wishlistRepository.save(wishlist);

            return "redirect:/wishlist/" + saved.getUsers().getId();
        } else {
            // 사용자 정보가 없는 경우에 대한 처리 (예: 로그인 상태가 아닌 경우)
            // 추후 로그인 후 이용해주세요? 같은 팝업창이나 alert창 추가
            return "redirect:/users/login"; // 로그인 페이지로 리다이렉트
        }
    }
}
