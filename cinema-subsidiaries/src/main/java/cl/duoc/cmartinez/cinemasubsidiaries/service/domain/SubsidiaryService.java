package cl.duoc.cmartinez.cinemasubsidiaries.service.domain;

import cl.duoc.cmartinez.cinemasubsidiaries.repository.SubsidiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsidiaryService {
  @Autowired
  private SubsidiaryRepository repository;

  public List<Subsidiary> getSubsidiaries() {
    return repository.getAll();
  }

  public Subsidiary getSubsidiaryById(int id) {
    List<Subsidiary> subsidiaries = repository.getAll();
    for (Subsidiary subsidiary : subsidiaries) {
      if (subsidiary.getId() == id) {
        return subsidiary;
      }
    }
    return null;
  }

  public boolean save(Subsidiary subsidiary) {
    Subsidiary found = repository.getByNameOrAddress(subsidiary);
    if(found == null){
      repository.save(subsidiary);
      return true;
    }
    return false;
  }

  public boolean replace(int id, Subsidiary newSubsidiary){
    Subsidiary found = null;
    List<Subsidiary> subsidiaries = repository.getAll();
    for (Subsidiary subsidiary : subsidiaries) {
      if (subsidiary.getId() == id) {
        found = subsidiary;
      }
    }

    if(found != null){
      repository.replace(found, newSubsidiary);
      return true;
    }

    return false;
  }

  public boolean delete(int id){
    Subsidiary found = null;
    List<Subsidiary> subsidiaries = repository.getAll();
    for (Subsidiary subsidiary : subsidiaries) {
      if (subsidiary.getId() == id) {
        found = subsidiary;
      }
    }

    if(found != null){
      repository.delete(found);
      return true;
    }

    return false;
  }
}
