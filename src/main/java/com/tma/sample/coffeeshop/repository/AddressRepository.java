package com.tma.sample.coffeeshop.repository;


import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.model.Store;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.annotation.security.RunAs;
import javax.swing.*;
import java.util.List;



public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByStoreId(long storeId);

    List<Address> findByCustomerId( long customerId);

    List<Address> findByCustomerId( long customerId,Pageable pageable);


}
