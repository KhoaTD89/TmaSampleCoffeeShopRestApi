package com.tma.sample.coffeeshop;

import com.tma.sample.coffeeshop.enums.ProductSize;
import com.tma.sample.coffeeshop.model.ProductDetail;
import com.tma.sample.coffeeshop.repository.ProductDetailRepository;
import com.tma.sample.coffeeshop.repository.ProductReposiroty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductDetailRepoTest {
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    ProductReposiroty productReposiroty;

    ProductDetail productDetail;

    List<ProductDetail> productDetailsRet;

    @Test
    void testFindAddressByStoreId(){
        given: setupProductDetails();
        and: insertOneProductDetails();
        when: findByProductIdAndSizeIsCalled();
        then: verifyActualProductDetailsRetContainsOne();
    }

    @Test
    public void anotherTest(){

    }

    private void verifyActualProductDetailsRetContainsOne() {
        Assertions.assertEquals(productDetailsRet.get(0).getPrice(),94);
    }

    private void findByProductIdAndSizeIsCalled() {
        productDetailsRet = productDetailRepository.findByProductIdAndSize(1, ProductSize.M);
    }

    private void insertOneProductDetails() {
        productDetailRepository.save(productDetail);
    }

    private void setupProductDetails() {
        productDetail = ProductDetail.builder()
                .product(productReposiroty.getById(1L))
                .price(94)
                .size(ProductSize.M)
                .build();
    }

}
