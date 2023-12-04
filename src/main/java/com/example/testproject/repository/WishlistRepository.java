package com.example.testproject.repository;


import com.example.testproject.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    boolean existsByUsersUsernameAndProductProductNum(String username, Long productNum);

    Optional<Wishlist> findByUsersAndProductProductNum(Long userId, Long productNum);

//    @Query(value = "DELETE FROM wishlist w " +
//            "WHERE w.users_id = :userId " +
//            "AND w.product.product_num = :productNum", nativeQuery = true)
//    void deleteByIdAndProductProductNum(@Param("userId") Long userId, @Param("productNum") Long productNum);
}