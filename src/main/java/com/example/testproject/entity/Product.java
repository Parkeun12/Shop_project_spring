package com.example.testproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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

//    //내용 보존을 위한(부분수정)메소드
//    public void patch(Product product){
//        if(product.productName != null)
//            this.productName = product.productName;
////        if(product.productPrice != null)
////            this.productPrice = product.productPrice;
//        if(product.productImg != null)
//            this.productImg = product.productImg;
//        if(product.productTxt != null)
//            this.productTxt = product.productTxt;
//        if(product.productColor != null)
//            this.productColor = product.productColor;
//        if(product.productSize != null)
//            this.productSize = product.productSize;
//    }
}
