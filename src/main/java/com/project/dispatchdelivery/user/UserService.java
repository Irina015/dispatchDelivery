package com.project.dispatchdelivery.user;

import com.project.dispatchdelivery.db.UsersRepository;
import com.project.dispatchdelivery.db.entity.User;
import com.project.dispatchdelivery.db.entity.UsersEntity;
import com.project.dispatchdelivery.db.request.userRequest.UserRegisterRequest;
import com.project.dispatchdelivery.db.response.UserResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    // constructor
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // register, creation
//    public void register(String username, String password,String firstName, String lastName, String phoneNumber, String emailAddress) {
//        UserDetails user = User.builder()
//                .username(username)
//                .password(passwordEncoder.encode(password))
//                .roles("USER")
//                .build();
//        userDetailsManager.createUser(user);
//        usersRepository.updateNameByUsername(username, firstName, lastName);
//        usersRepository.updatePhoneEmailByUsername(username, phoneNumber, emailAddress);
//    }

    public UserResponse createNewUser(UserRegisterRequest userRegisterRequest) {
        // lastName, firstName, email, password
        UsersEntity dbuser = usersRepository.createCustomer(userRegisterRequest);
        User user = new User();
        UserResponse userResponse = new UserResponse();
        if (dbuser != null) {
            String s = Integer.toString((int)dbuser.getId());
            user.setUID(s);
            user.setFirstName(dbuser.getFirstName());
            user.setLastName(dbuser.getLastName());
            user.setPhone(dbuser.getPhoneNumber());
            user.setEmail(dbuser.getEmailAddress());
            userResponse.setMessage("Registration Success");
            userResponse.setUser(user);
            userResponse.setStatus("200");
        } else {
            userResponse.setMessage("Registration failed");
            userResponse.setStatus("404");
        }
        return userResponse;
    }

    // getUser, find by id
    public UsersEntity findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }


    // update user
    public UserResponse updateUser (User updatedUser) {
        UserResponse userResponse = new UserResponse();
        UsersEntity dbuser = usersRepository.updateUser(updatedUser);
        User user = new User();
        if (dbuser != null) {
            String s = Integer.toString((int)dbuser.getId());
            user.setUID(s);
            user.setFirstName(dbuser.getFirstName());
            user.setLastName(dbuser.getLastName());
            user.setPhone(dbuser.getPhoneNumber());
            user.setEmail(dbuser.getEmailAddress());
            userResponse.setMessage("Update Success.");
            userResponse.setUser(user);
            userResponse.setStatus("200");
        } else {
            userResponse.setMessage("Update failed");
            userResponse.setStatus("404");
        }
        return userResponse;
    }

    // check password whether is correct
    public User checkUserPassword(String email, String password) {
        UsersEntity customer = usersRepository.checkUserPassword(email, password);
        return new User(customer.getEmailAddress(), customer.getLastName(),
                String.valueOf(customer.getId()), customer.getFirstName(), customer.getPhoneNumber());
    }

}
