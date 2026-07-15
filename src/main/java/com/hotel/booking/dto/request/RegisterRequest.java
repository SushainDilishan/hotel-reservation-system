package com.hotel.booking.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "First Name is Required")
    @Size(min = 2, max = 50, message = "First name has to be between 2-50 characters")
    private String firstName;

    @NotBlank(message = "Last Name is Required")
    @Size(min = 2, max = 50, message = "Last name has to be between 2-50 characters")
    private String lastName;

    @Email(message = "Email must be a valid email format")
    private String email;

//    @Pattern(regexp = "^(\\\\d{3}[- .]?){2}\\\\d{4}$"
//    ,message = "Invalid phone no format")
    private String phone;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 100, message = "Password must be 8-100 characters")
    private String password;

}
