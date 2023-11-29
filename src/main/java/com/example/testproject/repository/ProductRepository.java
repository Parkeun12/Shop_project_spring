package com.example.testproject.repository;

import com.example.testproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //CRUD 레포지토리에 있는 findAll 메소드를 오버라이드하여
    //Iterable 하위에 있는
    @Override
    ArrayList<Product> findAll();

    @Query("select P.productNum, P.productName, P.productPrice" +
            "from wishlist W, product P" +
            "where W.productNum = P.productNum")

    ArrayList<Product> findProductNameProductPrice();
}