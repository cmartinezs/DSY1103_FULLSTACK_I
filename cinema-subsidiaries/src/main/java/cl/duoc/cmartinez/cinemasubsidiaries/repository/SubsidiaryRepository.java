package cl.duoc.cmartinez.cinemasubsidiaries.repository;

import cl.duoc.cmartinez.cinemasubsidiaries.service.domain.Subsidiary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubsidiaryRepository {
  List<Subsidiary> subsidiaries;

  public SubsidiaryRepository() {
    subsidiaries = new ArrayList<>();
    subsidiaries.add(new Subsidiary(10, "Sucursal 1", "Por ahi", "999cito", 2000, true));
    subsidiaries.add(new Subsidiary(20, "Sucursal 2", "Muy muy lejano", "777cito", 1500, true));
    subsidiaries.add(
        new Subsidiary(30, "Sucursal 3", "Una galaxia muy lejana", "12341234", 3000, true));
  }

  public List<Subsidiary> getAll() {
    return subsidiaries;
  }

  public void save(Subsidiary subsidiary) {
    subsidiary.setId((subsidiaries.size() + 1) * 10);
    subsidiaries.add(subsidiary);
  }

  public void replace(Subsidiary found, Subsidiary newSubsidiary) {
    int idx = subsidiaries.indexOf(found);
    newSubsidiary.setId(found.getId());
    subsidiaries.set(idx, newSubsidiary);
  }

  public void delete(Subsidiary found) {
    subsidiaries.remove(found);
  }

  public Subsidiary getByNameOrAddress(Subsidiary subsidiary) {
    for(Subsidiary sub : subsidiaries){
      if(sub.getName().equals(subsidiary.getName())
              || sub.getAddress().equals(subsidiary.getAddress())){
        return sub;
      }
    }
    return null;
  }
}
