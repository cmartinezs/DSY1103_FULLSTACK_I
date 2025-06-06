package cl.duoc.cmartinez.cinemasubsidiaries.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubsidiaryJPARepository
    extends JpaRepository<SubsidiaryJPA,Integer> {
    List<SubsidiaryJPA> findByNameOrAddress(String name, String address);
}
