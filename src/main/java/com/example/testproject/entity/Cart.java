package com.example.testproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart {
    //장바구니 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_num;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userJoinId")
    private User_join user_join; // 구매자

    private int count; // 카트에 담긴 총 상품 개수

    private int price; // 카트에 담긴 총 상품 가격

    @OneToMany(mappedBy = "cart")
    private List<Cart_item> cart_items = new ArrayList<>();

    //프로덕트 테이블의 상품 번호
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_num")
    Product product;


    public static Cart createCart(User_join user_join) {
        Cart cart = new Cart();
        cart.setCount(0);
        cart.setUser_join(user_join);
        return cart;
    }

//    //장바구니 내의 상품 가격
//    @Column(name = "product_price")
//    private int productPrice;
//
//    //장바구니 내의 상품 수량
//    @Column(name = "product_count")
//    private int productCount;
//
//    //유저 테이블의 유저 아이디
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="userJoinId")
//    User_join user_join;
//

//
//    private int count; // 카트에 담긴 상품 개수

}
