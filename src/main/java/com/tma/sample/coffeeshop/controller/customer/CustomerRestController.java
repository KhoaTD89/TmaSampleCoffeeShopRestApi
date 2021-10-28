package com.tma.sample.coffeeshop.controller.customer;

import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.dto.OrderDetailPostDTO;
import com.tma.sample.coffeeshop.service.AddressService;
import com.tma.sample.coffeeshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    OrderService orderService;
    @Autowired
    AddressService addressService;

    @PostMapping("/{customerId}/stores/{storeId}")
    public boolean createNewOrder(
            @PathVariable long customerId,
            @PathVariable long storeId
    ){
        return orderService.createNewOrder(customerId,storeId);}

    @PostMapping("/orders/{orderId}/product/{productId}")
    public boolean addAnProductIntoOrder(
            @PathVariable long orderid,
            @PathVariable long productId,
            @RequestBody OrderDetailPostDTO orderDetailDTO
            ){
        return orderService.addProductToOrder(orderDetailDTO,orderid,productId);}

    @GetMapping("/{customerId}/addresses")
    public Page<AddressViewDTO> getAllAddresses(@PathVariable long customerId, Pageable pageable) {
        return addressService.getAllAddressesOfCustomer(customerId,pageable);
    }

}
















