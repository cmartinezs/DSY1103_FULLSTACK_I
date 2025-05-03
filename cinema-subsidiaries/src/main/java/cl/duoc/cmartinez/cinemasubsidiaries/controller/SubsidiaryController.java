package cl.duoc.cmartinez.cinemasubsidiaries.controller;

import cl.duoc.cmartinez.cinemasubsidiaries.domain.Subsidiary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subsidiaries")
public class SubsidiaryController {
  List<Subsidiary> subsidiaries;

  public SubsidiaryController() {
    subsidiaries = new ArrayList<>();
    subsidiaries.add(
        new Subsidiary(10, "Sucursal 1", "Por ahi", "999cito", 2000, true)
    );
    subsidiaries.add(
        new Subsidiary(20, "Sucursal 2", "Muy muy lejano", "777cito", 1500, true)
    );
    subsidiaries.add(
        new Subsidiary(30, "Sucursal 3", "Una galaxia muy lejana", "12341234", 3000, true)
    );
  }

  @GetMapping
  public List<Subsidiary> getSubsidiaries() {
    return subsidiaries;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Subsidiary> getSubsidiary(@PathVariable int id) {
    for (Subsidiary subsidiary : subsidiaries) {
      if (subsidiary.getId() == id) {
        return ResponseEntity.ok(subsidiary);
      }
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Void> addSubsidiary(@RequestBody Subsidiary subsidiary) {
    subsidiaries.add(subsidiary);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateSubsidiary(
          @PathVariable int id,
          @RequestBody Subsidiary request) {
    Subsidiary found = null;
    for (Subsidiary subsidiary : subsidiaries) {
      if (subsidiary.getId() == id) {
        found = subsidiary;
      }
    }

    if (found != null) {
      int index = subsidiaries.indexOf(found);
      subsidiaries.set(index, request);
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSubsidiary(@PathVariable int id) {
    Subsidiary found = null;
    for (Subsidiary subsidiary : subsidiaries) {
      if (subsidiary.getId() == id) {
        found = subsidiary;
      }
    }
    if (found != null) {
      subsidiaries.remove(found);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
