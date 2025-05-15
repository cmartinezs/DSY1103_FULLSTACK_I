package cl.duoc.cmartinez.authentication.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRepo {
  private int id;
  private String username;
  private String password;
  private String email;
}
