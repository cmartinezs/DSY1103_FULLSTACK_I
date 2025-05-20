package cl.duoc.cmartinez.authentication.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
  List<UserRepo> users = new ArrayList<>();

  public void save(UserRepo user) {
    users.add(user);
  }

  public int save(String username, String password, String email, String validationCode) {
    int id = users.size() + 1;
    users.add(new UserRepo(id, username, password, email, validationCode, false));
    return id;
  }

  public UserRepo getByUsername(String username) {
    for (UserRepo user : users) {
      if (user.getUsername().equals(username)) {
        return user;
      }
    }
    return null;
  }

  public UserRepo getByUsernameOrEmail(String username, String email) {
    for (UserRepo user : users) {
      if (user.getUsername().equals(username)
              || user.getEmail().equals(email)) {
        return user;
      }
    }
    return null;
  }
}
