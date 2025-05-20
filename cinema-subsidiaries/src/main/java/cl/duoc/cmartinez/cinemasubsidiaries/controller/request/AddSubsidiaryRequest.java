package cl.duoc.cmartinez.cinemasubsidiaries.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSubsidiaryRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    private int capacity;
}
