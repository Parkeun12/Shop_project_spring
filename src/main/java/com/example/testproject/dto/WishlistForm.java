package com.example.testproject.dto;

import com.example.testproject.entity.Product;
import com.example.testproject.entity.Users;
import com.example.testproject.entity.Wishlist;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class WishlistForm {

    private Long wishlistId;
    private Long userId;
    private Long productNum;

    public Wishlist toEntity() {
        Users users = new Users();
        users.setId(userId);

        Product product = new Product();
        product.setProductNum(productNum);

        return new Wishlist(wishlistId, users, product);
    }
}
