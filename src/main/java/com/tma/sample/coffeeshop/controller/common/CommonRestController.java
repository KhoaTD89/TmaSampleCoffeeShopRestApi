package com.tma.sample.coffeeshop.controller.common;

import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.dto.ProductDTO;
import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.service.AddressService;
import com.tma.sample.coffeeshop.service.MenuService;
import com.tma.sample.coffeeshop.service.ProductService;
import com.tma.sample.coffeeshop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommonRestController {

    @Autowired
    private StoreService storeService;
    @Autowired
    MenuService menuService;
    @Autowired
    ProductService productService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/stores")
    public ResponseEntity<Page<StoreDTO>> getAllStores(Pageable pageable) {
        return ResponseEntity.ok()
                .body(storeService.findAll(pageable));
    }

    @GetMapping("/stores/{storeId}")
    public ResponseEntity<StoreDTO> viewStoreDetail(@PathVariable long storeId) {
        return ResponseEntity.ok()
                .body(storeService.viewStoreDetail(storeId));
    }

    @GetMapping("/stores/{storeId}/products")
    public ResponseEntity<Page<ProductDTO>> getProductsOfAStore(@PathVariable long storeId, Pageable pageable) {
        return ResponseEntity.ok()
                .body(productService.getAllProductOfAStore(storeId, pageable));
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("productId") long productId) {
        return ResponseEntity.ok()
                .body(productService.getProductById(productId));
    }

    @GetMapping("/addresses/{addressId}")
    public ResponseEntity<AddressViewDTO> getAddressbyId(@PathVariable long addressId) {
        return ResponseEntity.ok()
                .body(addressService.getOne(addressId));
    }

}
