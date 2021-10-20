package com.tma.sample.coffeeshop;

import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import com.tma.sample.coffeeshop.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest
class AddressRopeTest {
    @Autowired
    AddressRepository addressRepository;

    @Test
    void testFindAddressByStoreId(){
        List<Address> addresses = addressRepository.findByCustomerId(100);
        System.out.println(addresses.size());
        System.out.println(addresses.get(0).getId());
        Assertions.assertTrue(addresses.size()>0);
    }

}
