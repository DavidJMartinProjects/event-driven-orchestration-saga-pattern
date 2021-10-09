package com.cart.repository;

import com.cart.model.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author david
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
