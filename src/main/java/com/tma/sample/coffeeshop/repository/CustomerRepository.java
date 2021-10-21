package com.tma.sample.coffeeshop.repository;

import com.tma.sample.coffeeshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
