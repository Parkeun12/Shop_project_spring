package com.example.testproject.repository;


import com.example.testproject.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

//    List<Wishlist> findByUsersUserId(String Id);
}
