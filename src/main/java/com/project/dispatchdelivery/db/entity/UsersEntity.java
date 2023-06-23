package com.project.dispatchdelivery.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table("users")
public class UsersEntity implements Serializable {

        private static final long serialVersionUID = 7596499365251992523L;

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private long id;


        private String username;
        private String authorities;
        private String password;

        @JsonProperty("email_address")
        private String emailAddress;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("phone_number")
        private String phoneNumber;

        // private List<OrderEntity> orderEntities;

        @OneToMany(mappedBy = "users")
        private List<CreditCardEntity> creditCardEntities;

        @OneToMany(mappedBy = "users")
        private List<OrderEntity> orderEntities;

        public User extract() {
                User user = new User();
                user.setEmail(this.emailAddress);
                user.setLastName(lastName);
                user.setFirstName(firstName);
                user.setUID(String.valueOf(id));
                user.setPhone(phoneNumber);
                return user;
        }

}
