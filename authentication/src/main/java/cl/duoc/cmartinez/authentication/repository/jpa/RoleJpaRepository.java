package cl.duoc.cmartinez.authentication.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleJpaRepository extends JpaRepository<RoleDB, Integer> {
    Optional<RoleDB> findByName(String name);
}
