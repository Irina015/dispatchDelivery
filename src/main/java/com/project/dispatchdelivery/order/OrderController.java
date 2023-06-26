package com.project.dispatchdelivery.order;

import com.project.dispatchdelivery.db.entity.UsersEntity;
import com.project.dispatchdelivery.model.OrderRequestBody;
import com.project.dispatchdelivery.user.UserService;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    //hardcode user for temp use, will be replaced in the future
    //private final UsersEntity userEntity = new UsersEntity(1L,"user0","Foo", "Bar","1001001000","12345","123@gmail.com");

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }


    @PostMapping
    public void createOrder(@AuthenticationPrincipal User user, @RequestBody OrderRequestBody body){
        UsersEntity userEntity = userService.findByUsername(user.getUsername());
        try {
            //System.out.println(body);
            orderService.createOrder(userEntity, body);
        } catch (DbActionExecutionException e) {
            throw e;
        }
    }

//    @DeleteMapping
//    public void unsetFavoriteItem(@AuthenticationPrincipal User user, @RequestBody OrderRequestBody body) {
//        UsersEntity userEntity = userService.findByUsername(user.getUsername());
//        orderService.cancelOrder(userEntity, body);
//    }

}
