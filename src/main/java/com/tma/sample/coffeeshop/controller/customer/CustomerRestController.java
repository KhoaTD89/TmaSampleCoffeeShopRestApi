package com.tma.sample.coffeeshop.controller.customer;

import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.dto.OrderDetailPostDTO;
import com.tma.sample.coffeeshop.service.AddressService;
import com.tma.sample.coffeeshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    OrderService orderService;
    @Autowired
    AddressService addressService;

    @PostMapping("/{customerId}/stores/{storeId}")
    public ResponseEntity<Object> createNewOrder(
            @PathVariable long customerId,
            @PathVariable long storeId
    ){
        orderService.createNewOrder(customerId,storeId);
        return ResponseEntity.ok()
                .body("created new empty order");
    }

    @PostMapping("/orders/{orderId}/product/{productId}")
    public ResponseEntity<Object> addAProductIntoOrder(
            @PathVariable long orderid,
            @PathVariable long productId,
            @RequestBody OrderDetailPostDTO orderDetailDTO
            ){
        orderService.addProductToOrder(orderDetailDTO,orderid,productId);
        return ResponseEntity.ok()
                .body(String.format("added product %s to order %s",orderid,productId));
    }

    @GetMapping("/{customerId}/addresses")
    public Page<AddressViewDTO> getAllAddresses(@PathVariable long customerId, Pageable pageable) {
        return addressService.getAllAddressesOfCustomer(customerId,pageable);
    }

}
















