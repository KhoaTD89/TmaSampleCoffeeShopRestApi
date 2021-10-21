package com.tma.sample.coffeeshop.controller.customer;

import com.tma.sample.coffeeshop.dto.OrderDetailPostDTO;
import com.tma.sample.coffeeshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order/store/{storeId}/customer/{customerId}")
    public boolean createNewOrder(
            @PathVariable("customerId") long customerId,
            @PathVariable("storeId") long storeId
    ){
        return orderService.createNewOrder(customerId,storeId);
    }

    @PostMapping("/order/{orderId}/item/{productId}")
    public boolean addAnProductIntoOrder(
            @PathVariable("orderId") long orderid,
            @PathVariable("productId") long productId,
            @RequestBody OrderDetailPostDTO orderDetailDTO
            ){
        return orderService.addProductToOrder(orderDetailDTO,orderid,productId);
    }



}
