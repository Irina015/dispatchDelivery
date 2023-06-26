package com.project.dispatchdelivery;

import com.project.dispatchdelivery.db.UsersRepository;
import com.project.dispatchdelivery.db.entity.UsersEntity;
import com.project.dispatchdelivery.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DevelopmentTester implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(DevelopmentTester.class);


    //private final UserService userService;

    public DevelopmentTester(){

    }
//    public DevelopmentTester(UserService userService) {
//        this.userService = userService;
//    }

    @Override

    public void run(ApplicationArguments args) {
        userService.register("default", "123456", "John", "Smith", "123-456-7890", "john@gmail.com");
        userService.register("admin", "123456", "Mary", "Smith", "123-456-7890", "mary@gmail.com");
        userService.register("user1", "123456", "Joe", "Smith", "123-456-7890", "joe@gmail.com");
        userService.register("user2", "123456", "Juan", "Smith", "123-456-7890", "juan@gmail.com");
        userService.register("user3", "123456", "Lin", "Smith", "123-456-7890", "lin@gmail.com");


    }

}
