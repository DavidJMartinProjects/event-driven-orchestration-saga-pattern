package com.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author david
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private long id;

    private String name;
    private String category;
    private double price;

}
