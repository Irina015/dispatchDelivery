package com.project.dispatchdelivery.order;

import com.project.dispatchdelivery.db.OrderRepository;
import com.project.dispatchdelivery.db.entity.OrderEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @GetMapping("/createOrder")
    public void createOrder(){
        OrderEntity newOrder = new OrderEntity(null, 1L,"beijing","new york", "July20","July25");
        orderRepository.save(newOrder);
    }
}
