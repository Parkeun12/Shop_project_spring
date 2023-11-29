package com.example.testproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
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

    //Wishlist와 양방향 매핑
    @OneToMany(mappedBy = "product")
    private List<Wishlist> wishlists = new ArrayList<>();

    public Product(Long productNum, String productName, int productPrice, String productImg, String productTxt, String productColor, String productSize) {
        this.productNum = productNum;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImg = productImg;
        this.productTxt = productTxt;
        this.productColor = productColor;
        this.productSize = productSize;
    }
}
