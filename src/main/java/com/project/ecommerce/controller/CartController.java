package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Cart;
import com.project.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PutMapping("/update")
    public String updateCart(@RequestBody Cart cart) {
        cartService.updateCart(cart);
        return "success";
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable Long id) {
        return cartService.getCart(id);
    }

    @PostMapping("/{id}/empty")
    public String emptyCart(@PathVariable Long id) {
        cartService.emptyCart(id);
        return "Cart is empty";
    }

    @PostMapping("/addProductToCart/{customerId}/{productId}/{quantity}")
    public String addProductToCart(@PathVariable Long customerId, @PathVariable Long productId, @PathVariable int quantity) {
        cartService.AddProductToCart(customerId, productId, quantity);
        return "success";
    }

    @DeleteMapping("removeProductFromCart/{customerId}/{productId}/{quantity}")
    public String removeProductFromCart(@PathVariable Long customerId, @PathVariable Long productId, @PathVariable int quantity) {
        cartService.RemoveProductFromCart(customerId, productId, quantity);
        return "success";
    }

}
