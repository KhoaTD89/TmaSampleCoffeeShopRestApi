package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.OrderDetailPostDTO;
import com.tma.sample.coffeeshop.model.Order;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderService {

    boolean createNewOrder(long customerId, long storeId);


    /*
    * @param
    * orderId
    * productId
    * voucherId
    * */
    boolean addProductToOrder(OrderDetailPostDTO orderDatailDTO
            , long orderId, long productId);
}
