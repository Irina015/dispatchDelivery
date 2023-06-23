package com.project.dispatchdelivery;

import com.project.dispatchdelivery.db.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DispatchDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DispatchDeliveryApplication.class, args);
    }

    public CommandLineRunner commandLineRunner(UsersRepository usersRepository) {
        return runner -> {

        };
    }

}
