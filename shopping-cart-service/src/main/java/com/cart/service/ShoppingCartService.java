package com.cart.service;

import com.cart.model.dto.CartDto;
import com.cart.model.dto.ItemDto;

/**
 * @author david
 */
public interface ShoppingCartService {
    CartDto createShoppingCart(CartDto cart);
    CartDto addItem(long cartId, ItemDto item);
    CartDto getShoppingCartById(long id);
}
