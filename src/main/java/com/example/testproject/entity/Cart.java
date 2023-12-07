package com.example.testproject.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    //회원 아이디 양방향 매핑
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    //상품 아이디 양방향 매핑
    @ManyToOne
    @JoinColumn(name = "product_num")
    private Product product;

    //장바구니에 담을 수량 체크
    private int count;

    public void addCount(int count) {
        this.count += count;
    }
}
