package com.example.testproject.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
//@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productNum;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private int productPrice;

    @Column(name = "product_img")
    private String productImg;

    @Column(name = "product_txt")
    private String productTxt;

    @Column(name = "product_color")
    private String productColor;

    @Column(name = "product_size")
    private String productSize;
}
