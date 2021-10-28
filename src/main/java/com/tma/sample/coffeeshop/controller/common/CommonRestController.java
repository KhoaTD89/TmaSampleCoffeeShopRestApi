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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
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
    public Page<StoreDTO> getAllStores(Pageable pageable){
        return storeService.findAll(pageable);
    }

    @GetMapping("/stores/{storeId}")
    public StoreDTO viewStoreDetail(@PathVariable long storeId){
        StoreDTO storeDTO = storeService.viewStoreDetail(storeId);
        return storeDTO;
    }

//    @GetMapping("/stores/{storeId}/products")
//    public Page<ProductDTO> getProductsOfAStore(@PathVariable long storeId,Pageable pageable){
//        return productService.getAllProductOfAStore(storeId,pageable);
//    }

    @GetMapping("/products/{productId}")
    public ProductDTO getProductById(@PathVariable("productId") long productId){
        return productService.getProductById(productId);
    }

    @GetMapping("/{addressId}")
    public AddressViewDTO getAddressbyId(@PathVariable long addressId) {
        return addressService.getOne(addressId);
    }

}
