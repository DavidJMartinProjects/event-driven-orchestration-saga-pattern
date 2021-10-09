package com.cart.controller;

import com.cart.model.dto.CartDto;
import com.cart.model.dto.ItemDto;
import com.cart.service.impl.ShoppingCartServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author david
 */
@RestController
@RequestMapping(ShoppingCartController.CART_BASE_PATH)
@Slf4j
public class ShoppingCartController {

    public static final String CART_BASE_PATH = "/cart";
    public static final String ADD_ITEM_URL = "/add";

    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @GetMapping
    public ResponseEntity<List<CartDto>> getShoppingCarts() {
        log.info("GET: {}", CART_BASE_PATH);
        return ResponseEntity.ok(shoppingCartService.getShoppingCarts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getShoppingCart(@PathVariable long id) {
        log.info("GET: {}{}", CART_BASE_PATH, "/" + id);
        return ResponseEntity.ok(shoppingCartService.getShoppingCartById(id));
    }

    @PostMapping("/{id}" + ADD_ITEM_URL)
    public ResponseEntity<CartDto> postShoppingCart(@PathVariable long cartId, @RequestBody ItemDto item) {
        log.info("POST: {}", CART_BASE_PATH);
        return ResponseEntity.ok(shoppingCartService.addItem(cartId, item));
    }

}
