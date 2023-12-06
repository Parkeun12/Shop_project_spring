package com.example.testproject.dto;

import com.example.testproject.entity.Cart;
import com.example.testproject.entity.Product;
import com.example.testproject.entity.Users;
import com.example.testproject.entity.Wishlist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CartForm {

    private Long cartId;
    private Long userId;
    private Long productNum;

    public Cart toEntity() {
        Users users = new Users();
        users.setId(userId);

        Product product = new Product();
        product.setProductNum(productNum);

        return new Cart(cartId, users, product);
    }
}
