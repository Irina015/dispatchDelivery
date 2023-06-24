package com.project.dispatchdelivery.db.response;

import com.project.dispatchdelivery.db.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class GetCustomerResponse {
    private String status;
    private String message;
    private User user;
}
