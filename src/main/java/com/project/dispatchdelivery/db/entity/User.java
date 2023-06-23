package com.project.dispatchdelivery.db.entity;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String email;
    private String lastName;
    private String UID;
    private String firstName;
    private String phone;

    public UsersEntity ToUsersEntity() {
        UsersEntity customer = new UsersEntity();
        customer.setEmailAddress(this.email);
        customer.setLastName(this.lastName);
        customer.setFirstName(this.firstName);
        customer.setPhoneNumber(this.phone);
        return customer;
    }
}
