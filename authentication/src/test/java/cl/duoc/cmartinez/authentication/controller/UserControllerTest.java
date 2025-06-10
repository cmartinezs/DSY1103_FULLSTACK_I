package cl.duoc.cmartinez.authentication.controller;

import cl.duoc.cmartinez.authentication.controller.request.RegisterRequest;
import cl.duoc.cmartinez.authentication.controller.response.RegisterResponse;
import cl.duoc.cmartinez.authentication.service.RegisterUserResult;
import cl.duoc.cmartinez.authentication.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @Test
    void register_ok() {
        // Given
        RegisterRequest request = new RegisterRequest("testuser", "password123", "email");
        RegisterUserResult result = new RegisterUserResult(1, "validationCode123");
        given(userService.registerUser(
                request.getUsername(),
                request.getPassword(),
                request.getEmail())
        ).willReturn(result);
        // When
        ResponseEntity<RegisterResponse> response = userController.register(request);
        // Then
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(201), response.getStatusCode());
        RegisterResponse body = response.getBody();
        assertNotNull(body);
        assertEquals("User registered successfully", body.getMessage());
        assertEquals(1, body.getId());
        assertEquals("validationCode123", body.getValidationCode());
      }

    @Test
    void register_nok_exists_user() {
        // Given
        RegisterRequest request = new RegisterRequest("testuser", "password123", "email");
        RegisterUserResult result = new RegisterUserResult(-1, "validationCode123");
        given(userService.registerUser(
                request.getUsername(),
                request.getPassword(),
                request.getEmail())
        ).willReturn(result);
        // When
        ResponseEntity<RegisterResponse> response = userController.register(request);
        // Then
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(400), response.getStatusCode());
        RegisterResponse body = response.getBody();
        assertNotNull(body);
        assertEquals("Username or email already exists", body.getMessage());
        assertEquals(-1, body.getId());
        assertEquals(null, body.getValidationCode());
    }

    @Test
    void login() {
      }

    @Test
    void validate() {
      }

    @Test
    void enrolling() {
      }

    @Test
    void getUserByUsername() {
      }
}