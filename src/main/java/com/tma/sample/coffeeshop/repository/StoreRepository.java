package com.tma.sample.coffeeshop.repository;


import com.tma.sample.coffeeshop.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
}
