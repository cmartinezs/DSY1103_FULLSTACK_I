package cl.duoc.cmartinez.authentication.controller.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollUserRequest {
    @NotNull(message = "Role ID is required")
    @Min(value = 1, message = "Role ID must be greater than 0")
    private Integer roleId;
}
