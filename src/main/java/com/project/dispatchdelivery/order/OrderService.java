package com.project.dispatchdelivery.order;

import com.project.dispatchdelivery.db.OrderRepository;
import com.project.dispatchdelivery.db.entity.OrderEntity;
import com.project.dispatchdelivery.db.entity.UsersEntity;
import com.project.dispatchdelivery.model.orderModel.OrderRequestBody;
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
        OrderEntity newOrder = new OrderEntity(null, user.id(),
                body.senderAddress(), body.senderCity(), body.senderState(), body.senderEmail(), body.senderPhone().phoneNumber(),
                body.receiverAddress(), body.receiverCity(), body.receiverState(), body.receiverEmail(), body.receiverPhone().phoneNumber());
        orderRepository.save(newOrder);
    }

    //cancelOrder
    public void cancelOrder(UsersEntity user, OrderRequestBody body){
        OrderEntity order = orderRepository.findAllByUserId(body.userId());
        orderRepository.delete(order);
    }
}
