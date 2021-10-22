package com.tma.sample.coffeeshop;

import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import com.tma.sample.coffeeshop.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
class StoreRepoTest {
    @Autowired
    AddressRepository addressRepository;

    @Test
    void contextLoads() {
        String hh = "23:00";
        LocalTime localTime= Utils.formatStringToLocalTime(hh);
        System.out.println(localTime);
        Assertions.assertEquals(1,1);
    }

    @Test
    void testFindAddressByStoreId(){
        List<Address> byStoreId = addressRepository.findByStoreId(2);
        System.out.println(byStoreId.get(0).getId());
        Assertions.assertTrue(byStoreId.size()>0);
    }

    @Test
    void findByCustomerId(){
        List<Address> byStoreId = addressRepository.findByCustomerId(1);
        System.out.println(byStoreId.get(0).getId());
        Assertions.assertTrue(byStoreId.size()>0);
    }

}
