package com.project.dispatchdelivery.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public record UsersEntity(
        @Id int id,
        String username,
        String firstName,
        String lastName,
        String phoneNumber,
        String password,
        String emailAddress
){
}
