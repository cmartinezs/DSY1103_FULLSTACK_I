package cl.duoc.cmartinez.authentication.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewRoleRequest {
    @NotBlank(message = "Name is required")
    @Size(message = "Name must be greater than 3 characters", min = 3, max = 15)
    private String name;
}
