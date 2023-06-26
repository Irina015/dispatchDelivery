package com.project.dispatchdelivery.order;

import com.project.dispatchdelivery.db.OrderRepository;
import com.project.dispatchdelivery.db.entity.OrderEntity;
import com.project.dispatchdelivery.db.entity.UsersEntity;
import com.project.dispatchdelivery.model.OrderRequestBody;
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
    public void createOrder(UsersEntity user, OrderRequestBody body){
        OrderEntity newOrder = new OrderEntity(null, user.id(), body.fromLocation(), body.toLocation(), body.pickupDate(), body.deliveryDate());
        orderRepository.save(newOrder);
    }

    //cancelOrder

}
