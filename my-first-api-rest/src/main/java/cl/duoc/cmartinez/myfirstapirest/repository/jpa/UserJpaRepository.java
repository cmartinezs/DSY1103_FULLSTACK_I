package cl.duoc.cmartinez.myfirstapirest.repository.jpa;

import cl.duoc.cmartinez.myfirstapirest.repository.jpa.entity.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserJpa, Long> {}
