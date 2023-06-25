package com.project.dispatchdelivery;

import com.project.dispatchdelivery.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
    public void run(ApplicationArguments args){

    }


//    @Override
//    public void run(ApplicationArguments args) {
//        userService.register("default", "123456", "John", "Smith", "123-123-1234", "123@gmail.com");
//    }

}
