package com.project.dispatchdelivery.db.response;

import com.project.dispatchdelivery.db.entity.User;
import lombok.*;


@ToString
public class GetCustomerResponse {
    private String status;
    private String message;
    private User user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
