package com.tma.sample.coffeeshop.repository;


import com.tma.sample.coffeeshop.model.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByStoreId(long storeId);

    List<Address> findByCustomerId( long customerId);

//    List<Address> findByCustomerIdTest( long customerId,Pageable pageable);


}
