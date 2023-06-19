package com.project.dispatchdelivery.user;

import com.project.dispatchdelivery.db.UsersRepository;
import com.project.dispatchdelivery.db.entity.UsersEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;


    public UserService(UserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder, UsersRepository usersRepository) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }


    public void register(String username, String password, String firstName, String lastName) {
        UserDetails user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();
        userDetailsManager.createUser(user);
        usersRepository.updateNameByUsername(username, firstName, lastName);
    }


    public UsersEntity findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
