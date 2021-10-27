package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.dto.OrderDetailPostDTO;

public interface OrderService {

    boolean createNewOrder(long customerId, long storeId);

    boolean addProductToOrder(OrderDetailPostDTO orderDatailDTO, long orderId, long productId);
}
