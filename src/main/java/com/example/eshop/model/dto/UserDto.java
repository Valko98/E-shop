package com.example.eshop.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


public class UserDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;

    @Email
    @NotEmpty
    private String confirmEmail;

}
