package com.product.repository;

import com.product.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author david
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
