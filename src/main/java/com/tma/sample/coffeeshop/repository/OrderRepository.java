package com.tma.sample.coffeeshop.repository;


import com.tma.sample.coffeeshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
