package com.tma.sample.coffeeshop.repository;


import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
