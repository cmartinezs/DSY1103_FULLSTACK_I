package cl.duoc.cmartinez.authentication.service;

import cl.duoc.cmartinez.authentication.repository.UserDB;
import cl.duoc.cmartinez.authentication.repository.UserJpaRepository;
import cl.duoc.cmartinez.authentication.repository.UserRepo;
import cl.duoc.cmartinez.authentication.repository.UserRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
  @Autowired //private UserRepository repository;
  UserJpaRepository repository;

  public RegisterUserResult registerUser(String username, String password, String email) {
    List<UserDB> founds = repository.findByUsernameOrEmail(username, email);
    if (!founds.isEmpty()) {
      return new RegisterUserResult(-1, null);
    }
    String validationCode = UUID.randomUUID().toString();
    UserDB newUser = new UserDB();
    newUser.setUsername(username);
    newUser.setPassword(password);
    newUser.setEmail(email);
    newUser.setValidationCode(validationCode);
    UserDB saved = repository.save(newUser);
    return new RegisterUserResult(saved.getId(), validationCode);
  }

  public boolean validateLogin(String username, String password) {
    List<UserDB> founds = repository.findByUsernameOrEmail(username, null);
    if (founds.isEmpty()) {
      return false;
    }
    UserDB found = founds.get(0);
    if (!found.isValidated()) {
      return false;
    }

    if (found.getPassword().equals(password)) {
      return true;
    }

    return false;
  }

  public boolean validateUser(
      String username, @NotBlank(message = "Validation code is required") String validationCode) {
    List<UserDB> founds = repository.findByUsernameOrEmail(username, null);
    if (founds.isEmpty()) {
      return false;
    }
    UserDB found = founds.get(0);
    if (found.getValidationCode().equals(validationCode)) {
      found.setValidated(true);
      found.setValidationCode(null);
      repository.save(found);
      return true;
    }

    return false;
  }
}
