package cl.duoc.cmartinez.authentication.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewRoleResponse {
    private Integer id;
    private String name;
    private String message;
}
