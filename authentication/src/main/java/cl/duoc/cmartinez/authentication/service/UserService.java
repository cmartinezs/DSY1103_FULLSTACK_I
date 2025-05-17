package cl.duoc.cmartinez.authentication.service;

import cl.duoc.cmartinez.authentication.repository.UserRepo;
import cl.duoc.cmartinez.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public int registerUser(String username,
                           String password,
                           String email) {
    UserRepo found = repository.getByUsernameOrEmail(username, email);
    if (found != null) {
      return -1;
    }
    return repository.save(username, password, email);
  }

  public boolean validateLogin(
          String username,
          String password) {
    UserRepo found = repository.getByUsernameOrEmail(username, null);
    if (found == null) {
      return false;
    }

    if(found.getPassword().equals(password)){
      return true;
    }

    return false;

  }
}
