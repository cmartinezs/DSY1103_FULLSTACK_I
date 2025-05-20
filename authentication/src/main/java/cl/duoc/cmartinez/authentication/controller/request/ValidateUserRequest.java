package cl.duoc.cmartinez.authentication.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidateUserRequest {
  @NotBlank(message = "Validation code is required")
  private String validationCode;
}
