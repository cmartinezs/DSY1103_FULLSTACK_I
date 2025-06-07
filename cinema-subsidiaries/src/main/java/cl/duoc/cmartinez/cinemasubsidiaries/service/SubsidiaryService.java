package cl.duoc.cmartinez.cinemasubsidiaries.service;

import cl.duoc.cmartinez.cinemasubsidiaries.repository.entity.SubsidiaryEntity;
import cl.duoc.cmartinez.cinemasubsidiaries.repository.jpa.SubsidiaryJPA;
import cl.duoc.cmartinez.cinemasubsidiaries.repository.jpa.SubsidiaryJPARepository;
import cl.duoc.cmartinez.cinemasubsidiaries.service.domain.Subsidiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubsidiaryService {
  @Autowired private SubsidiaryJPARepository repository;

  public List<Subsidiary> getSubsidiaries() {
    List<SubsidiaryJPA> subsidiaries = repository.findAll();
    List<Subsidiary> aux = new ArrayList<>();
    for (SubsidiaryJPA sub : subsidiaries) {
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
    /*List<Subsidiary> subsidiaries = getSubsidiaries();
    for (Subsidiary subsidiary : subsidiaries) {
      if (subsidiary.getId() == id) {
        return subsidiary;
      }
    }*/

    Optional<SubsidiaryJPA> opt = repository.findById(id);
    if(opt.isPresent()) {
      SubsidiaryJPA sub  = opt.get();
      return new Subsidiary(
              sub.getId(),
              sub.getName(),
              sub.getAddress(),
              sub.getPhone(),
              sub.getCapacity(),
              sub.isActive());
    }
    return null;
  }

  public boolean save(Subsidiary sub) {
    List<SubsidiaryJPA> founds = repository.findByNameOrAddress(sub.getName(), sub.getAddress());
    if (founds.isEmpty()) {
      repository.save(
          new SubsidiaryJPA(
              null,
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
    Optional<SubsidiaryJPA> opt = repository.findById(id);
    if(!opt.isPresent()) {
      return false;
    }

    SubsidiaryJPA sub = opt.get();
    sub.setName(newSubsidiary.getName());
    sub.setAddress(newSubsidiary.getAddress());
    sub.setPhone(newSubsidiary.getPhone());
    sub.setCapacity(newSubsidiary.getCapacity());
    sub.setActive(newSubsidiary.isActive());
    repository.save(sub);
    return true;
  }

  public boolean delete(int id) {
    boolean exists = repository.existsById(id);
    if(!exists) {
      return false;
    }
    repository.deleteById(id);
    return true;
  }
}
