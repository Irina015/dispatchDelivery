package com.project.dispatchdelivery;

import com.project.dispatchdelivery.db.OrderRepository;
import com.project.dispatchdelivery.db.entity.OrderEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {

        System.out.println("springboot started");
        return "hello world";
    }

}
