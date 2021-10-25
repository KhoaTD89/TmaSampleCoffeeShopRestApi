package com.tma.sample.coffeeshop.controller.customer;

import com.tma.sample.coffeeshop.dto.OrderDetailPostDTO;
import com.tma.sample.coffeeshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/orders")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @PostMapping("/store/{storeId}/customer/{customerId}")
    public boolean createNewOrder(
            @PathVariable long customerId,
            @PathVariable long storeId
    ){
        return orderService.createNewOrder(customerId,storeId);
    }

    @PostMapping("/{orderId}/product/{productId}")
    public boolean addAnProductIntoOrder(
            @PathVariable long orderid,
            @PathVariable long productId,
            @RequestBody OrderDetailPostDTO orderDetailDTO
            ){
        return orderService.addProductToOrder(orderDetailDTO,orderid,productId);
    }


}
