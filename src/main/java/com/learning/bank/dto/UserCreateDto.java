package com.learning.bank.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserCreateDto {
    @NotBlank(message = "First name is mandatory field")
    private String firstName;

    @NotBlank(message = "Last name is mandatory field")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
