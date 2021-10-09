package com.cart.model.mapper;

import com.cart.model.dto.CartDto;
import com.cart.model.entity.CartEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author david
 */
@Component
@Slf4j
public class CartMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CartDto toDto(CartEntity cartEntity) {
        log.debug("mapping entity with id: {} to dto.", cartEntity.getId());
        return modelMapper.map(cartEntity, CartDto.class);
    }

    public CartEntity toEntity(CartDto cartDto) {
        log.debug("mapping dto with to entity.");
        return modelMapper.map(cartDto, CartEntity.class);
    }

}
