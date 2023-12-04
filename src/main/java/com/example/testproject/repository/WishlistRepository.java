package com.example.testproject.repository;


import com.example.testproject.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    boolean existsByUsersUsernameAndProductProductNum(String username, Long productNum);

    Optional<Wishlist> deleteByUsersUsernameAndProductProductNum(String username, Long productNum);


}