package com.cart.repository;

import com.cart.model.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author david
 */
@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
