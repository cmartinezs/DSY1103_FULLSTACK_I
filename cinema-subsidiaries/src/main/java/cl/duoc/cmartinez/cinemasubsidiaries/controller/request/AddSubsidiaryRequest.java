package cl.duoc.cmartinez.cinemasubsidiaries.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSubsidiaryRequest {
    private String name;
    private String address;
    private String phone;
    private int capacity;
}
