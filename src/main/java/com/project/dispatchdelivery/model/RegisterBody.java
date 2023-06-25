package com.project.dispatchdelivery.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RegisterBody(
        String username,
        String password,
        String firstName,
        String lastName,
        String phoneNumber,
        String emailAddress
) {
}