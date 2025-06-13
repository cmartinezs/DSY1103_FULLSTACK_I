package cl.duoc.cmartinez.myfirstapirest.repository.jpa;

import cl.duoc.cmartinez.myfirstapirest.repository.jpa.entity.ProductJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductJpaRespository extends JpaRepository<ProductJpa, Long> {
    Optional<ProductJpa> findByName(String aName);
}
