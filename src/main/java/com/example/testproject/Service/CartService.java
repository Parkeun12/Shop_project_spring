package com.example.testproject.Service;

import com.example.testproject.entity.Cart;
import com.example.testproject.entity.Cart_item;
import com.example.testproject.entity.Product;
import com.example.testproject.entity.User_join;
import com.example.testproject.repository.CartRepository;
import com.example.testproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Transactional
    public void addCart(User_join user_join Product product, int amount) {

        // 유저 id로 해당 유저의 장바구니 찾기
        Cart cart = cartRepository.findByUserId(user_join.getId());

        // 장바구니가 존재하지 않는다면
        if (cart == null) {
            cart = Cart.createCart(user_join);
            cartRepository.save(cart);
        }

        Product product = ProductRepository.findproductById(newproduct.getId());
        Cart_item cart_item = cart_itemRepository.findByCartIdAndItemId(cart.getId(), item.getId());

        // 상품이 장바구니에 존재하지 않는다면 카트상품 생성 후 추가
        if (cartItem == null) {
            cartItem = CartItem.createCartItem(cart, item, amount);
            cart_itemRepository.save(cartItem);
        }

        // 상품이 장바구니에 이미 존재한다면 수량만 증가
        else {
            CartItem update = cartItem;
            update.setCart(cartItem.getCart());
            update.setItem(cartItem.getItem());
            update.addCount(amount);
            update.setCount(update.getCount());
            cart_itemRepository.save(update);
        }

        // 카트 상품 총 개수 증가
        cart.setCount(cart.getCount()+amount);

    }
}
