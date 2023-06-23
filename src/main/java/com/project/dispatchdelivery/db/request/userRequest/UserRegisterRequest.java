package com.project.dispatchdelivery.db.request.userRequest;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRegisterRequest {
    public String LastName;
    public String FirstName;
    public String Email;
    public String Password;
}
