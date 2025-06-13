package cl.duoc.cmartinez.myfirstapirest.repository.jpa;

import cl.duoc.cmartinez.myfirstapirest.repository.jpa.entity.InventoryJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryJpaRepository
        extends JpaRepository<InventoryJpa, Long> {}
