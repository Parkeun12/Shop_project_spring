package com.example.testproject.entity;

import jakarta.persistence.*;
import lombok.*;

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

    //장바구니 내의 상품 가격
    @Column(name = "product_price")
    private int productPrice;

    //장바구니 내의 상품 수량
    @Column(name = "product_count")
    private int productCount;

    //유저 테이블의 유저 아이디
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userJoinId")
    User_join user_join;

    //프로덕트 테이블의 상품 번호
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_num")
    Product product;

    public Cart(Long cartNum, int productPrice, int productCount, Long productNum, Long userJoinId) {
    }
}
