package com.example.testproject.dto;


import com.example.testproject.entity.Product;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@ToString
public class ProductForm {
    private Long productNum;
    private String productName;
    private int productPrice;
    private MultipartFile productImg;
    private String productTxt;
    private String productColor;
    private String productSize;

    public Product toEntity(){
        return new Product(productNum, productName, productPrice, productImg.getOriginalFilename(), productTxt, productColor, productSize);
    }
}
