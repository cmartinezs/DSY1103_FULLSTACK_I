package cl.duoc.cmartinez.authentication.controller;

import cl.duoc.cmartinez.authentication.controller.request.RegisterRequest;
import cl.duoc.cmartinez.authentication.controller.response.RegisterResponse;
import cl.duoc.cmartinez.authentication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  @Autowired private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
    int id = userService.registerUser(
            request.getUsername(),
            request.getPassword(),
            request.getEmail());

    if (id < 0) {
      return ResponseEntity.badRequest().body(new RegisterResponse("Username or email already exists", -1));
    }
    RegisterResponse re = new RegisterResponse("User registered successfully", id);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(re);
  }
}
