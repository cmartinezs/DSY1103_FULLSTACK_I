package cl.duoc.cmartinez.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository
        extends JpaRepository<UserDB, Integer> {
    List<UserDB> findByUsernameOrEmail(
            String username, String email);
}
