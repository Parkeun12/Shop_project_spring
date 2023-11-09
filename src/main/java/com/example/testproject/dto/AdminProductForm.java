package com.example.testproject.dto;


import com.example.testproject.entity.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class AdminProductForm {
    private Long product_num;
    private String product_name;
    private int product_price;
    private String product_img;
    private String product_txt;
    private String product_color;
    private String product_size;

    public Product toEntity(){
        return new Product(product_num, product_name, product_price, product_img, product_txt, product_color, product_size);
    }
}
