package com.project.dispatchdelivery.db.response.userResponse;

import com.project.dispatchdelivery.db.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserResponse {
    private String status;
    private String message;
    private User user;
}
