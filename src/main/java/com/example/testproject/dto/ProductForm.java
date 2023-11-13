package com.example.testproject.dto;


import com.example.testproject.entity.Product;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ProductForm {
    private Long productNum;
    private String productName;
    private int productPrice;
    private String productImg;
    private String productTxt;
    private String productColor;
    private String productSize;

    public Product toEntity(){
        return new Product(productNum, productName, productPrice, productImg, productTxt, productColor, productSize);
    }
}
