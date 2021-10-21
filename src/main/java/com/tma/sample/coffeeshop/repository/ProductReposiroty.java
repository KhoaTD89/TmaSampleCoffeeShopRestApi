package com.tma.sample.coffeeshop.repository;

import com.tma.sample.coffeeshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReposiroty extends JpaRepository<Product,Long> {
}
