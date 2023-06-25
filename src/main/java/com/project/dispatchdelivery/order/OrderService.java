package com.project.dispatchdelivery.order;

import com.project.dispatchdelivery.db.OrderRepository;
import com.project.dispatchdelivery.db.entity.OrderEntity;
import com.project.dispatchdelivery.db.entity.UsersEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    //createOrder
    public void createOrder(UsersEntity user){
        OrderEntity newOrder = new OrderEntity(1, user.id(), "beijing", "new york", "July21", "July30");
        orderRepository.save(newOrder);
    }

    //cancelOrder

    //getOrder
}
