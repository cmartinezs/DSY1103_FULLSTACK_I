package cl.duoc.cmartinez.authentication.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResult {
    private String username;
    private String email;
    private String role;
}
