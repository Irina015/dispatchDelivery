package com.project.dispatchdelivery.user;

import com.project.dispatchdelivery.db.UsersRepository;
import com.project.dispatchdelivery.db.entity.User;
import com.project.dispatchdelivery.db.entity.UsersEntity;
import com.project.dispatchdelivery.db.request.userRequest.UserRegisterRequest;
import com.project.dispatchdelivery.db.response.userResponse.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    // constructor
    public UserService(UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder, UsersRepository usersRepository) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
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
}
