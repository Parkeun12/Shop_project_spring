package com.example.testproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cart_num")
    private Cart cart;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_num")
    private Product product;

    private int count; // 상품 개수

    public static Cart_item createCart_item(Cart cart, Product product, int amount) {
        Cart_item cart_item = new Cart_item();
        Cart_item.setCart(cart);
        Cart_item.setProduct(product);
        Cart_item.setCount(amount);
        return cart_item;
    }

    // 이미 담겨있는 물건 또 담을 경우 수량 증가
    public void addCount(int count) {
        this.count += count;
    }
}
