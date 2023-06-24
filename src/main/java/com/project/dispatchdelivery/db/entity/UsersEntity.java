package com.project.dispatchdelivery.db.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class UsersEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "authorities")
        private String authorities;
        @Column(name = "password")
        private String password;

        @Column(name = "email_address")
        private String emailAddress;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "phone_number")
        private String phoneNumber;

        @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @Fetch(value = FetchMode.SUBSELECT)
        private List<CreditCardEntity> creditCardEntities;

        @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @Fetch(value = FetchMode.SUBSELECT)
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

        public long getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
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

        public UsersEntity(int id,  String password, String firstName, String lastName, String phoneNumber,String emailAddress) {
                this.id = id;
                this.password = password;

                this.firstName = firstName;
                this.lastName = lastName;
                this.phoneNumber = phoneNumber;
                this.emailAddress = emailAddress;
        }

        public UsersEntity(){};

        @Override
        public String toString() {
                return "UsersEntity{" +
                        "id=" + id +
                        ", authorities='" + authorities + '\'' +
                        ", password='" + password + '\'' +
                        ", emailAddress='" + emailAddress + '\'' +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'' +
                        ", creditCardEntities=" + creditCardEntities +
                        ", orderEntities=" + orderEntities +
                        '}';
        }
}
