package com.cart.model.mapper;

import com.cart.model.dto.ItemDto;
import com.cart.model.entity.ItemEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author david
 */
@Component
@Slf4j
public class ItemMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ItemDto toDto(ItemEntity itemEntity) {
        log.debug("mapping entity with id: {} to dto.", itemEntity.getId());
        return modelMapper.map(itemEntity, ItemDto.class);
    }

    public ItemEntity toEntity(ItemDto itemDto) {
        log.debug("mapping dto with to entity.");
        return modelMapper.map(itemDto, ItemEntity.class);
    }

}
