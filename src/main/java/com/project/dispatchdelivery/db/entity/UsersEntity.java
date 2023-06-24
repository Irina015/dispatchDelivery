package com.project.dispatchdelivery.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class UsersEntity implements Serializable {

        private static final long serialVersionUID = 7596499365251992523L;

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private long id;


        private String username;
        private String authorities;
        private String password;


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

//        public User extract() {
//                User user = new User();
//
//                user.setEmail(this.emailAddress);
//                user.setLastName(lastName);
//                user.setFirstName(firstName);
//                user.setUID(String.valueOf(id));
//                user.setPhone(phoneNumber);
//                return user;
//        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getAuthorities() {
                return authorities;
        }

        public void setAuthorities(String authorities) {
                this.authorities = authorities;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmailAddress() {
                return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
                this.emailAddress = emailAddress;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public List<CreditCardEntity> getCreditCardEntities() {
                return creditCardEntities;
        }

        public void setCreditCardEntities(List<CreditCardEntity> creditCardEntities) {
                this.creditCardEntities = creditCardEntities;
        }

        public List<OrderEntity> getOrderEntities() {
                return orderEntities;
        }

        public void setOrderEntities(List<OrderEntity> orderEntities) {
                this.orderEntities = orderEntities;
        }

        public UsersEntity(long id, String username, String password, String firstName, String lastName, String phoneNumber,String emailAddress) {
                this.id = id;
                this.username = username;
                this.password = password;

                this.firstName = firstName;
                this.lastName = lastName;
                this.phoneNumber = phoneNumber;
                this.emailAddress = emailAddress;
        }

        public UsersEntity(){};
}
