package com.tma.sample.coffeeshop.unittest.service;

import com.tma.sample.coffeeshop.dto.OrderDetailPostDTO;
import com.tma.sample.coffeeshop.enums.OrderStatus;
import com.tma.sample.coffeeshop.enums.ProductSize;
import com.tma.sample.coffeeshop.model.ExtraOption;
import com.tma.sample.coffeeshop.model.Order;
import com.tma.sample.coffeeshop.model.OrderDetail;
import com.tma.sample.coffeeshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ProductReposiroty productReposiroty;
    @Autowired
    ExtraOptionRepository extraOptionRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public boolean createNewOrder(long customerId, long storeId) {
        try{
            Order order = new Order();
            order.setCustomer(customerRepository.getById(customerId));
            order.setStore(storeRepository.getById(storeId));
            order.setOrderStatus(OrderStatus.PROCESSING);
            orderRepository.save(order);
            return true;
        }catch(Exception e){
            System.out.println("***could not create order");
            return false;
        }
    }

    /*
    * @param
    * orderId
    * productId
    * voucherId
    * */
    @Override
    public boolean addProductToOrder(OrderDetailPostDTO orderDatailDTO
            ,long orderId, long productId) {
        try {
            //find order by id
            Order order = orderRepository.getById(orderId);

            //find extra option
            ExtraOption extraOption = extraOptionRepository.getById(orderDatailDTO.getExtraOptionId());

            //set values
            OrderDetail orderDetail = OrderDetail.builder()
                    .order(order)
                    .extraOption(extraOption)
                    .productDetail(productDetailRepository.findByProductIdAndSize(productId,
                            ProductSize.valueOf(orderDatailDTO.getSize().toUpperCase())).get(0))
                    .productQty(orderDatailDTO.getProductQty())
                    .note(orderDatailDTO.getNote())
                    .itemPrice(1123)
                    .build();

            //save to DB
            orderDetailRepository.save(orderDetail);

            return true;
        }catch (Exception e){
            System.out.println("***** could not add the product");
            return false;
        }
    }
}
