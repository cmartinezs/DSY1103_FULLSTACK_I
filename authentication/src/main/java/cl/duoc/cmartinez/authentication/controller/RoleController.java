package cl.duoc.cmartinez.authentication.controller;

import cl.duoc.cmartinez.authentication.controller.request.NewRoleRequest;
import cl.duoc.cmartinez.authentication.controller.response.NewRoleResponse;
import cl.duoc.cmartinez.authentication.service.NewRoleResult;
import cl.duoc.cmartinez.authentication.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
  @Autowired
  private RoleService roleService;

  @PostMapping("/new")
  public ResponseEntity<NewRoleResponse> createNewRole(@Valid @RequestBody NewRoleRequest request) {
    NewRoleResult result = roleService.saveRole(request.getName());
    return ResponseEntity.ok()
        .body(new NewRoleResponse(result.getId(), request.getName(), "Role created successfully"));
  }
}
