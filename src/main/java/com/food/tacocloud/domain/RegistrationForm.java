package com.food.tacocloud.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Base64;

@Data
@Builder
public class RegistrationForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String address;

    public User toUser() {
        return User.builder().username(username).password(Base64.getEncoder().encodeToString(password.getBytes()))
                .firstName(firstName).lastName(lastName).mobileNumber(mobileNumber).address(address).build();
    }
}
