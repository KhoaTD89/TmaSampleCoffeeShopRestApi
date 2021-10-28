package com.tma.sample.coffeeshop.repository;


import com.tma.sample.coffeeshop.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface AddressRepository extends JpaRepository<Address,Long> {

    Page<Address> findByStoreId(long storeId,Pageable pageable);
    List<Address> findAllByStoreId(long storeId);
    Page<Address> findByCustomerId( long customerId,Pageable pageable);









}
