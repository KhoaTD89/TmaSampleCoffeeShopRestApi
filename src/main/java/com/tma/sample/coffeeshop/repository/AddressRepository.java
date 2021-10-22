package com.tma.sample.coffeeshop.repository;


import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    //Conventional query
    List<Address> findByStoreId(long storeId);

    //Conventional query
    List<Address> findByCustomerId( long customerId);


}
