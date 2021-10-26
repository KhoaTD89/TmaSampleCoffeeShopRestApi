package com.tma.sample.coffeeshop.repository;

import com.tma.sample.coffeeshop.model.Category;
import com.tma.sample.coffeeshop.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District,Long> {
}
