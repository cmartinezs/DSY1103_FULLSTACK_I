package cl.duoc.cmartinez.cinemasubsidiaries.service;

import cl.duoc.cmartinez.cinemasubsidiaries.repository.SubsidiaryRepository;
import cl.duoc.cmartinez.cinemasubsidiaries.repository.entity.SubsidiaryEntity;
import cl.duoc.cmartinez.cinemasubsidiaries.service.domain.Subsidiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubsidiaryService {
  @Autowired private SubsidiaryRepository repository;

  public List<Subsidiary> getSubsidiaries() {
    List<SubsidiaryEntity> subsidiaries = repository.getAll();
    List<Subsidiary> aux = new ArrayList<>();
    for (SubsidiaryEntity sub : subsidiaries) {
      aux.add(
          new Subsidiary(
              sub.getId(),
              sub.getName(),
              sub.getAddress(),
              sub.getPhone(),
              sub.getCapacity(),
              sub.isActive()));
    }
    return aux;
  }

  public Subsidiary getSubsidiaryById(int id) {
    List<Subsidiary> subsidiaries = getSubsidiaries();
    for (Subsidiary subsidiary : subsidiaries) {
      if (subsidiary.getId() == id) {
        return subsidiary;
      }
    }
    return null;
  }

  public boolean save(Subsidiary sub) {
    SubsidiaryEntity found = repository.getByNameOrAddress(sub.getName(), sub.getAddress());
    if (found == null) {
      repository.save(
          new SubsidiaryEntity(
              sub.getId(),
              sub.getName(),
              sub.getAddress(),
              sub.getPhone(),
              sub.getCapacity(),
              sub.isActive()));
      return true;
    }
    return false;
  }

  public boolean replace(int id, Subsidiary newSubsidiary) {
    SubsidiaryEntity found = null;
    List<SubsidiaryEntity> subsidiaries = repository.getAll();
    for (SubsidiaryEntity subsidiary : subsidiaries) {
      if (subsidiary.getId() == id) {
        found = subsidiary;
      }
    }

    if (found != null) {
      repository.replace(
          found,
          new SubsidiaryEntity(
              newSubsidiary.getId(),
              newSubsidiary.getName(),
              newSubsidiary.getAddress(),
              newSubsidiary.getPhone(),
              newSubsidiary.getCapacity(),
              newSubsidiary.isActive()));
      return true;
    }

    return false;
  }

  public boolean delete(int id) {
    SubsidiaryEntity found = null;
    List<SubsidiaryEntity> subsidiaries = repository.getAll();
    for (SubsidiaryEntity subsidiary : subsidiaries) {
      if (subsidiary.getId() == id) {
        found = subsidiary;
      }
    }

    if (found != null) {
      repository.delete(found);
      return true;
    }

    return false;
  }
}
