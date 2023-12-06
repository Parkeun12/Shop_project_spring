package com.example.testproject.repository;

import com.example.testproject.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    boolean existsByUsersUsernameAndProductProductNum(String username, Long productNum);

}
