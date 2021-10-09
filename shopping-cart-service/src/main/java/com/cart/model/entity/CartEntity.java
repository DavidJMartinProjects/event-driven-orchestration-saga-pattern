package com.cart.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author david
 */
@Entity
@Table(name = "CART")
@Data
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "customer_id")
    private long customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_entity_id")
    private List<ItemEntity> itemEntities;

}
