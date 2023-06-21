package com.project.dispatchdelivery;

import com.project.dispatchdelivery.db.OrderRepository;
import com.project.dispatchdelivery.db.entity.OrderEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final OrderRepository orderRepository;

    public HelloController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/hello")
    public String sayHello() {

        OrderEntity newOrder = new OrderEntity(null, 1L,"beijing","new york", "July20","July25");
        orderRepository.save(newOrder);
        System.out.println("springboot started");
        return "hello world";
    }

}
