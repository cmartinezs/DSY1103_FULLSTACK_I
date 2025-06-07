package cl.duoc.cmartinez.authentication.service;

import cl.duoc.cmartinez.authentication.repository.jpa.RoleDB;
import cl.duoc.cmartinez.authentication.repository.jpa.RoleJpaRepository;
import cl.duoc.cmartinez.authentication.service.exception.DuplicatedRegisterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
  @Autowired private RoleJpaRepository repository;

  public NewRoleResult saveRole(String roleName) {
    Optional<RoleDB> opt = repository.findByName(roleName);
    if (opt.isPresent()) {
      throw new DuplicatedRegisterException("Role already exists: " + roleName);
    }
    RoleDB role = new RoleDB();
    role.setName(roleName);
    RoleDB savedRole = repository.save(role);
    return new NewRoleResult(savedRole.getId());
  }
}
