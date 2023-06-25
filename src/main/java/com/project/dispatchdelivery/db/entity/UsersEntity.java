package com.project.dispatchdelivery.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public record UsersEntity(
        @Id long id,
        String username,
        String password,
        String firstName,
        String lastName,
        String phoneNumber,
        String emailAddress
){
}
