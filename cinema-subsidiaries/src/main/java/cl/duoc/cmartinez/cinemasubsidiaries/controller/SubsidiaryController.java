package cl.duoc.cmartinez.cinemasubsidiaries.controller;

import cl.duoc.cmartinez.cinemasubsidiaries.controller.request.AddSubsidiaryRequest;
import cl.duoc.cmartinez.cinemasubsidiaries.service.domain.Subsidiary;
import cl.duoc.cmartinez.cinemasubsidiaries.service.SubsidiaryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subsidiaries")
public class SubsidiaryController {
  @Autowired
  private SubsidiaryService service;

  @GetMapping
  public List<Subsidiary> getSubsidiaries() {
    return service.getSubsidiaries();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Subsidiary> getSubsidiary(@PathVariable int id) {
    Subsidiary found = service.getSubsidiaryById(id);
    if (found != null) {
      return ResponseEntity.ok(found);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Void> addSubsidiary(
          @Valid @RequestBody AddSubsidiaryRequest request) {
    Subsidiary subsidiary = new Subsidiary(0,
            request.getName(),
            request.getAddress(),
            request.getPhone(),
            request.getCapacity(),
            true);

    boolean saved = service.save(subsidiary);
    if (saved) {
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateSubsidiary(
          @PathVariable int id,
          @RequestBody Subsidiary request) {
    boolean replaced = service.replace(id, request);
    if (replaced) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSubsidiary(@PathVariable int id) {
    boolean deleted = service.delete(id);
    if (deleted) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
