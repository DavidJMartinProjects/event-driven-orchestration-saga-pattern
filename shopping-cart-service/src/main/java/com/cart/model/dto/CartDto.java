package com.cart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author david
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private long id;
    private long customerId;
    private List<ItemDto> items;

    public List<ItemDto> addItem(ItemDto item) {
        items.add(item);
        return items;
    }

}
