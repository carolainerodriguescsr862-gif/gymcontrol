package com.csrodrigues.gymcontrol.api.dto.request;

import com.csrodrigues.gymcontrol.api.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {

    @NotBlank(message = "Invalid email ")
    private String email;
    @NotBlank(message = "Password cannot be empty")
    @ValidPassword
    private String password;

    public UserRequestDTO(){}

    public UserRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
