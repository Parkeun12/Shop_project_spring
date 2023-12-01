package com.example.testproject.repository;


import com.example.testproject.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    boolean existsByUsersUsernameAndProductProductNum(String username, Long productNum);

//    Optional<Wishlist> findByUsersUsernameAndProductNum(String username, String productNum);


}