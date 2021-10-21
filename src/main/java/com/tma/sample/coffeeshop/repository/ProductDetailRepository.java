package com.tma.sample.coffeeshop.repository;

import com.tma.sample.coffeeshop.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail,Long> {
}
