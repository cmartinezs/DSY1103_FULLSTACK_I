package cl.duoc.cmartinez.authentication.controller.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Username is required")
    @Size(message = "Username must be greater than 3 characters", min = 3, max = 15)
    private String username;
    @NotEmpty(message = "Password is required")
    @Size(message = "Password must be greater than 4 characters", min = 4, max = 15)
    private String password;
    @Email(message = "Email is not valid")
    private String email;
}
