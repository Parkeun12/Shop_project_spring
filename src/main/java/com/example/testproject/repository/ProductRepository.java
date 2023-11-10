package com.example.testproject.repository;

import com.example.testproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //CRUD 레포지토리에 있는 findAll 메소드를 오버라디으하여
    //Iterable 하위에 있느
    @Override
    ArrayList<Product> findAll();

}