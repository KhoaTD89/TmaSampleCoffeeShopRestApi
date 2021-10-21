package com.tma.sample.coffeeshop;

import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.model.Product;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import com.tma.sample.coffeeshop.repository.MenuRepository;
import com.tma.sample.coffeeshop.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest
class MenuRepoTest {
    @Autowired
    MenuRepository menuRepository;

    @Test
    void testFindProduct(){
        List<Product> productsOfAStore = menuRepository.findProductsOfAStore(1);
        Assertions.assertTrue(productsOfAStore.get(0)!=null);
    }
}
