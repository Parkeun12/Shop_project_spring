package com.example.testproject.repository;

import com.example.testproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdminProductRepository extends JpaRepository<Product, Long> {

}