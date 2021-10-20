package com.tma.sample.coffeeshop.repository;


import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query(value = "select A from Address  as  A where A.store.id=:storeId")
    List<Address> findByStoreId(@Param("storeId") long storeId);


    @Query(value = "select A from Address  as  A where A.customer.id=:customerId")
    List<Address> findByCustomerId(@Param("customerId") long customerId);


}
