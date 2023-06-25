package com.project.dispatchdelivery.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public record UsersEntity(
        @Id int id,
        String username,
        String password,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("phone_number")
        String phoneNumber,
        @JsonProperty("email_address")
        String emailAddress
){
}
