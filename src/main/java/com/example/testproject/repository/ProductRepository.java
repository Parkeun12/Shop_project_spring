package com.example.testproject.repository;

import com.example.testproject.entity.Product;
import com.example.testproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //CRUD 레포지토리에 있는 findAll 메소드를 오버라이드하여
    //Iterable 하위에 있는
    @Override
    ArrayList<Product> findAll();
    @Query(value = "select p.product_num, p.product_name, p.product_price, p.product_img, p.product_color, p.product_size, p.product_txt, w.wishlist_id " +
            "from wishlist w " +
            "inner join product p " +
            "on w.product_num=p.product_num " +
            "where w.users_id = :userId", nativeQuery = true)
    ArrayList<Product> findWishlistIdProductNameProductPriceByUserId(@Param("userId") Long userId);

    @Query(value = "select p.product_num, p.product_name, p.product_price, p.product_img, p.product_color, p.product_size, p.product_txt, c.cart_id " +
            "from cart c " +
            "inner join product p " +
            "on c.product_num=p.product_num " +
            "where c.users_id = :userId", nativeQuery = true)
    ArrayList<Product> findCartIdProductNameProductPriceByUserId(@Param("userId") Long userId);

}