package com.tma.sample.coffeeshop;

import com.tma.sample.coffeeshop.enums.ProductSize;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.model.ProductDetail;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import com.tma.sample.coffeeshop.repository.ProductDetailRepository;
import com.tma.sample.coffeeshop.repository.ProductReposiroty;
import com.tma.sample.coffeeshop.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

@SpringBootTest
class ProductDetailRepoTest {
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    ProductReposiroty productReposiroty;

    @Test
    void testFindAddressByStoreId(){
        ProductDetail productDetail = ProductDetail.builder()
                .product(productReposiroty.getById(1L))
                .price(94)
                .size(ProductSize.M)
                .build();
        productDetailRepository.save(productDetail);

        List<ProductDetail> var = productDetailRepository.findByProductIdAndSize(1, ProductSize.M);
        Assertions.assertEquals(var.get(0).getPrice(),94);
    }

}
