package com.example.identity.service.api.input;

import com.example.identity.service.annotations.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Max.Jimenez
 */
@Setter
@Getter
public class UserInput {

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Email should be valid"
    )
    private String email;

    @NotBlank(message = "Password is mandatory")
    @ValidPassword
    private String password;

    private List<@Valid PhoneInput> phones;
}
