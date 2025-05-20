package cl.duoc.cmartinez.authentication.service;

import cl.duoc.cmartinez.authentication.repository.UserRepo;
import cl.duoc.cmartinez.authentication.repository.UserRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
  @Autowired private UserRepository repository;

  public RegisterUserResult registerUser(String username, String password, String email) {
    UserRepo found = repository.getByUsernameOrEmail(username, email);
    if (found != null) {
      return new RegisterUserResult(-1, null);
    }
    String validationCode = UUID.randomUUID().toString();
    int id = repository.save(username, password, email, validationCode);
    return new RegisterUserResult(id, validationCode);
  }

  public boolean validateLogin(String username, String password) {
    UserRepo found = repository.getByUsernameOrEmail(username, null);
    if (found == null) {
      return false;
    }

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
    UserRepo found = repository.getByUsernameOrEmail(username, null);
    if (found == null) {
      return false;
    }

    if (found.getValidationCode().equals(validationCode)) {
      found.setValidated(true);
      found.setValidationCode(null);
      return true;
    }

    return false;
  }
}
