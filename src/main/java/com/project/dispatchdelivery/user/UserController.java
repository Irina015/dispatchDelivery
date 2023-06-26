package com.project.dispatchdelivery.user;

import com.project.dispatchdelivery.db.UsersRepository;
import com.project.dispatchdelivery.db.entity.UsersEntity;
import com.project.dispatchdelivery.model.RegisterBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.OK)

    public void register(@RequestBody RegisterBody body) {
        userService.register(
                body.username(),
                body.password(),
                body.firstName(),
                body.lastName(),
                body.phoneNumber(),
                body.emailAddress());

    }

    @GetMapping("/searchusers")
    public UsersEntity findByUsername() {
        return userService.findByUsername("scott");
    }


}
