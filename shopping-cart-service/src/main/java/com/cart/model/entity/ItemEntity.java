package com.cart.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author david
 */
@Entity
@Table(name = "CART_ITEMS")
@Data
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    private int quantity;
    private int productId;

}
