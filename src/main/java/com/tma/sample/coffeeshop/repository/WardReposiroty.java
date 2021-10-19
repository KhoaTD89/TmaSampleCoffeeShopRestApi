package com.tma.sample.coffeeshop.repository;

import com.tma.sample.coffeeshop.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardReposiroty extends JpaRepository<Ward,Long> {
}
