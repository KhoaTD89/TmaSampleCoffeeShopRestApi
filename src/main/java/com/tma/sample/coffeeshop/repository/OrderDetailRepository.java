package com.tma.sample.coffeeshop.repository;

import com.tma.sample.coffeeshop.model.City;
import com.tma.sample.coffeeshop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {


}
