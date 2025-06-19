package cl.duoc.cmartinez.authentication.controller;

import cl.duoc.cmartinez.authentication.controller.request.NewRoleRequest;
import cl.duoc.cmartinez.authentication.controller.response.NewRoleResponse;
import cl.duoc.cmartinez.authentication.service.NewRoleResult;
import cl.duoc.cmartinez.authentication.service.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoleControllerTest {

    @Mock
  private RoleService roleService;

    @InjectMocks
  private RoleController roleController;

  @Test
  void createNewRole() {
    // Given
    NewRoleRequest request = new NewRoleRequest("ROLE_ADMIN");
    NewRoleResult returned = new NewRoleResult();
    // WHen
    when(roleService.saveRole(request.getName())).thenReturn(returned);
    ResponseEntity<NewRoleResponse> response = roleController.createNewRole(request);
    // Then
    assertNotNull(response);
    assertEquals(HttpStatusCode.valueOf(201), response.getStatusCode());
    NewRoleResponse body = response.getBody();
    assertNotNull(body);
    assertEquals("ROLE_ADMIN", body.getName());
  }
}
