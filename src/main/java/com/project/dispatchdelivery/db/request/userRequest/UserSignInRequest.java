package com.project.dispatchdelivery.db.request.userRequest;

import lombok.*;
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSignInRequest {
        private String email;
        private String Password;

        public UserSignInRequest() {
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return Password;
        }

        public void setPassword(String password) {
                Password = password;
        }

        public UserSignInRequest(String email, String password) {
                this.email = email;
                Password = password;
        }
}
