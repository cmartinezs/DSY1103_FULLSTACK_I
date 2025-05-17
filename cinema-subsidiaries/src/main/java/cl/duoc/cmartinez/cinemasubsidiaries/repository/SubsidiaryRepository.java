package cl.duoc.cmartinez.cinemasubsidiaries.repository;

import cl.duoc.cmartinez.cinemasubsidiaries.repository.entity.SubsidiaryEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubsidiaryRepository {
  List<SubsidiaryEntity> subsidiaries;

  public SubsidiaryRepository() {
    subsidiaries = new ArrayList<>();
    subsidiaries.add(new SubsidiaryEntity(10, "Sucursal 1", "Por ahi", "999cito", 2000, true));
    subsidiaries.add(new SubsidiaryEntity(20, "Sucursal 2", "Muy muy lejano", "777cito", 1500, true));
    subsidiaries.add(
        new SubsidiaryEntity(30, "Sucursal 3", "Una galaxia muy lejana", "12341234", 3000, true));
  }

  public List<SubsidiaryEntity> getAll() {
    return subsidiaries;
  }

  public void save(SubsidiaryEntity subsidiary) {
    subsidiary.setId((subsidiaries.size() + 1) * 10);
    subsidiaries.add(subsidiary);
  }

  public void replace(SubsidiaryEntity found, SubsidiaryEntity newSubsidiary) {
    int idx = subsidiaries.indexOf(found);
    newSubsidiary.setId(found.getId());
    subsidiaries.set(idx, newSubsidiary);
  }

  public void delete(SubsidiaryEntity found) {
    subsidiaries.remove(found);
  }

  public SubsidiaryEntity getByNameOrAddress(String name, String address) {
    for(SubsidiaryEntity sub : subsidiaries){
      if(sub.getName().equals(name)
              || sub.getAddress().equals(address)){
        return sub;
      }
    }
    return null;
  }
}
