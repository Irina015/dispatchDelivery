package com.project.dispatchdelivery.order;

import com.project.dispatchdelivery.db.entity.UsersEntity;
import com.project.dispatchdelivery.model.OrderRequestBody;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private final OrderService orderService;

    //hardcode user for temp use, will be replaced in the future
   private final UsersEntity userEntity = new UsersEntity(1,"12345","Foo", "Bar","1001001000","123@gmail.com");

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping ("/createOrder")
    public void createOrder(@RequestBody OrderRequestBody body){
        try {
            orderService.createOrder(userEntity);
        } catch (DbActionExecutionException e) {
            throw e;
        }
        //need to get this newOrder info from request body:
    }
}
