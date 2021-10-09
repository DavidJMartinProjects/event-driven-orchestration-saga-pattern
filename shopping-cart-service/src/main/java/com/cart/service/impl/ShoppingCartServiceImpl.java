package com.cart.service.impl;

import com.amqp.common.model.MessageRequest;
import com.amqp.common.producer.MessageProducer;
import com.cart.exception.ShoppingCartException;
import com.cart.model.dto.CartDto;
import com.cart.model.dto.ItemDto;
import com.cart.model.mapper.CartMapper;
import com.cart.repository.CartRepository;
import com.cart.service.ShoppingCartService;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author david
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private static final String SHOPPING_CART_QUEUE = "cart-queue";

    private final Queue queue = new Queue(SHOPPING_CART_QUEUE, false);

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    private final MessageProducer messageProducer = new MessageProducer();

    @Autowired
    public ShoppingCartServiceImpl(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public CartDto createShoppingCart(CartDto cartDto) {
        return Optional.of(cartRepository.save(cartMapper.toEntity(cartDto)))
                .map(cartMapper::toDto)
                .orElseThrow(() -> new ShoppingCartException("Encounter error creating cart."));
    }

    @Override
    public CartDto addItem(long cartId, ItemDto item) {
        CartDto cartDto = getShoppingCartById(cartId);
        cartDto.addItem(item);

        MessageRequest message = MessageRequest.builder().message(cartDto.toString()).build();
        messageProducer.sendMessage(queue, message);

        return Optional.of(cartRepository.save(cartMapper.toEntity(cartDto)))
                .map(cartMapper::toDto)
                .orElseThrow(() -> new ShoppingCartException("Encounter error adding item with id: "+ cartId +" to cart."));
    }

    @Override
    public CartDto getShoppingCartById(long id) {
        return Optional.of(cartRepository.getById(id))
                .map(cartMapper::toDto)
                .orElseThrow(() -> new ShoppingCartException("Cart with Id "+ id +" not found."));
    }

    public List<CartDto> getShoppingCarts() {
        return cartRepository.findAll().stream()
                .map(cartMapper::toDto)
                .collect(Collectors.toList());
    }
}
