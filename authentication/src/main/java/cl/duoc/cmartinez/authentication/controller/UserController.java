package cl.duoc.cmartinez.authentication.controller;

import cl.duoc.cmartinez.authentication.controller.request.EnrollUserRequest;
import cl.duoc.cmartinez.authentication.controller.request.LoginRequest;
import cl.duoc.cmartinez.authentication.controller.request.RegisterRequest;
import cl.duoc.cmartinez.authentication.controller.request.ValidateUserRequest;
import cl.duoc.cmartinez.authentication.controller.response.LoginResponse;
import cl.duoc.cmartinez.authentication.controller.response.RegisterResponse;
import cl.duoc.cmartinez.authentication.service.GetUserResult;
import cl.duoc.cmartinez.authentication.service.RegisterUserResult;
import cl.duoc.cmartinez.authentication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  @Autowired private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
    RegisterUserResult result =
        userService.registerUser(request.getUsername(), request.getPassword(), request.getEmail());

    if (result.getId() < 0) {
      return ResponseEntity.badRequest()
          .body(new RegisterResponse("Username or email already exists", -1, null));
    }
    RegisterResponse re =
        new RegisterResponse(
            "User registered successfully", result.getId(), result.getValidationCode());
    return ResponseEntity.status(HttpStatus.CREATED).body(re);
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
    boolean validated = userService.validateLogin(request.getUsername(), request.getPassword());

    if (validated) {
      return ResponseEntity.ok(new LoginResponse("Login successful"));
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body(new LoginResponse("Invalid username or password"));
    }
  }

  @PatchMapping("/validate/{username}")
  public ResponseEntity<LoginResponse> validate(
      @PathVariable String username, @Valid @RequestBody ValidateUserRequest request) {
    boolean validated = userService.validateUser(username, request.getValidationCode());

    if (validated) {
      return ResponseEntity.ok(new LoginResponse("User validated successful"));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new LoginResponse("Error at validated user"));
    }
  }

  @PatchMapping("/enrolling/{username}")
  public ResponseEntity<LoginResponse> enrolling(
      @PathVariable String username, @Valid @RequestBody EnrollUserRequest request) {
    boolean enrolled = userService.enrollUser(username, request.getRoleId());

    if (enrolled) {
      return ResponseEntity.ok(new LoginResponse("User enrolled successfully"));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new LoginResponse("Error at enrolling user"));
    }
  }

  @GetMapping("/by-username/{username}")
  public ResponseEntity<GetUserResult> getUserByUsername(@PathVariable String username) {
    Optional<GetUserResult> user = userService.getUserByUsername(username);
    if (user.isPresent()) {
      return ResponseEntity.ok(user.get());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
