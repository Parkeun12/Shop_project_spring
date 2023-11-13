package com.example.testproject.dto;

import com.example.testproject.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CartForm {
    private Long cart_num;
    private int productPrice;
    private int productCount;

    private Long productNum;
    private Long userJoinId;

    public Cart toEntity() {
        return new Cart(null, productPrice, productCount, productNum, userJoinId);
    }
}


