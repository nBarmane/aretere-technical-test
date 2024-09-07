package com.example.artere.controller;

import com.example.artere.model.Cart;
import com.example.artere.model.CartItem;
import com.example.artere.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart createCart() {
        return cartService.createCart();
    }

    @PostMapping("/{cartId}/products/{productId}")
    public Cart addProductToCart(@PathVariable Long cartId,
                                 @PathVariable Long productId,
                                 @RequestParam int quantity) {
        return cartService.addProductToCart(cartId, productId, quantity);
    }

    @PutMapping("/{cartId}/products/{productId}")
    public CartItem updateCartItem(@PathVariable Long cartId,
                                   @PathVariable Long productId,
                                   @RequestParam int quantity) {
        return cartService.updateCartItem(cartId, productId, quantity);
    }

    @DeleteMapping("/{cartId}/products/{productId}")
    public void removeCartItem(@PathVariable Long cartId,
                               @PathVariable Long productId) {
        cartService.removeCartItem(cartId, productId);
    }

    @GetMapping("/{cartId}/total")
    public double getTotalCartPrice(@PathVariable Long cartId) {
        return cartService.getTotalCartPrice(cartId);
    }
}
