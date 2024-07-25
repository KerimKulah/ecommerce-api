package com.project.ecommerce.service;

import com.project.ecommerce.entity.Cart;

public interface CartService {
    void updateCart(Cart cart);
    Cart getCart(Long customerId);
    void emptyCart(Long customerId);
    void AddProductToCart(Long customerId, Long productId,int quantity);
    void RemoveProductFromCart(Long customerId, Long productId, int quantity);
}
