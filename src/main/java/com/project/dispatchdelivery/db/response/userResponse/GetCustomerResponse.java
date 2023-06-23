package com.project.dispatchdelivery.db.response.userResponse;

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
