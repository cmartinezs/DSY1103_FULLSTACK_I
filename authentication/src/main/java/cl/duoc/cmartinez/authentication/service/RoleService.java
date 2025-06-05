package cl.duoc.cmartinez.authentication.service;

import cl.duoc.cmartinez.authentication.repository.jpa.RoleDB;
import cl.duoc.cmartinez.authentication.repository.jpa.RoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleJpaRepository repository;

    public NewRoleResult saveRole(String roleName) {
        RoleDB role = new RoleDB();
        role.setName(roleName);
        RoleDB savedRole = repository.save(role);
        return new NewRoleResult(savedRole.getId());
    }
}
