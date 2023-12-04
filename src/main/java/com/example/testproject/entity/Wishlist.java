package com.example.testproject.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishlistId;

    //회원 아이디 양방향 매핑
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    //상품 아이디 양방향 매핑
    @ManyToOne
    @JoinColumn(name = "product_num")
    private Product product;
}
