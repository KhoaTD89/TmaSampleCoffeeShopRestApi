package com.tma.sample.coffeeshop.repository;

import com.tma.sample.coffeeshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
