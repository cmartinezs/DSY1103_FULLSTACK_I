package cl.duoc.cmartinez.myfirstapirest.repository.jpa;

import cl.duoc.cmartinez.myfirstapirest.repository.jpa.entity.OrderJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderJpa, Long> {}
