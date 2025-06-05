package cl.duoc.cmartinez.authentication.service;

import cl.duoc.cmartinez.authentication.repository.jpa.RoleDB;
import cl.duoc.cmartinez.authentication.repository.jpa.RoleJpaRepository;
import cl.duoc.cmartinez.authentication.repository.jpa.UserDB;
import cl.duoc.cmartinez.authentication.repository.jpa.UserJpaRepository;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * UserService is a service class that handles user registration, login validation, and user
 * validation in the authentication system.
 */
@Service
public class UserService {
  @Autowired
  private UserJpaRepository repository;

  @Autowired
  private RoleJpaRepository roleRepository;

  /**
   * Registers a new user with the provided username, password, and email. If a user with the same
   * username or email already exists, it returns an error code.
   *
   * @param username the username of the new user
   * @param password the password of the new user
   * @param email the email of the new user
   * @return a RegisterUserResult containing the user ID and validation code
   */
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

  /**
   * Validates the login credentials of a user. Checks if the user exists, if the account is
   * validated, and if the password matches.
   *
   * @param username the username or email of the user
   * @param password the password of the user
   * @return true if the login is valid, false otherwise
   */
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

  /**
   * Validates a user by checking the provided validation code against the user's stored validation
   * code. If the validation is successful, it marks the user as validated and clears the validation
   * code.
   *
   * @param username the username or email of the user
   * @param validationCode the validation code provided by the user
   * @return true if the validation is successful, false otherwise
   */
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

  // quiero poder dar de baja a un usuario
  public boolean deleteUser(String username) {
    List<UserDB> founds = repository.findByUsernameOrEmail(username, null);
    if (founds.isEmpty()) {
      return false;
    }
    UserDB found = founds.get(0);
    repository.delete(found);
    return true;
  }

  public boolean enrollUser(String username, Integer roleId) {
    List<UserDB> founds = repository.findByUsernameOrEmail(username, null);
    if (founds.isEmpty()) {
      return false;
    }
    UserDB found = founds.get(0);
    if (found.getRole() != null) {
      return false; // User already has a role assigned
    }

    Optional<RoleDB> optRole = roleRepository.findById(roleId);

    optRole.ifPresent(role -> {
      found.setRole(role);
      repository.save(found);
    });

    return optRole.isPresent();
  }

  public Optional<GetUserResult> getUserByUsername(String username) {
    List<UserDB> founds = repository.findByUsernameOrEmail(username, null);
    if (founds.isEmpty()) {
      return Optional.empty();
    }

    UserDB found = founds.get(0);
    return Optional.of(new GetUserResult(
        found.getUsername(),
        found.getEmail(),
        found.getRole() != null ? found.getRole().getName() : null
    ));
  }
}
