package com.example.testproject.repository;

import com.example.testproject.entity.Product;
import com.example.testproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //CRUD 레포지토리에 있는 findAll 메소드를 오버라이드하여
    //Iterable 하위에 있는
    @Override
    ArrayList<Product> findAll();

//    @Query(value = "select P.productNum, P.productName, P.productPrice" +
//            "from wishlist W, product P" +
//            "where W.productNum = P.productNum", nativeQuery = true)

    @Query(value = "select p.product_num, p.product_name, p.product_price, p.product_img, p.product_color, p.product_size, p.product_txt " +
            "from wishlist w " +
            "inner join product p " +
            "on w.product_num=p.product_num", nativeQuery = true)

    ArrayList<Product> findProductNameProductPrice();

    Users findByProductNum(String productNum);
}