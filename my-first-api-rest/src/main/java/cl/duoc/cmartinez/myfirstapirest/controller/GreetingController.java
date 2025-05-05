package cl.duoc.cmartinez.myfirstapirest.controller;

import cl.duoc.cmartinez.myfirstapirest.controller.request.GreetingRequest;
import cl.duoc.cmartinez.myfirstapirest.controller.response.GreetingResponse;
import cl.duoc.cmartinez.myfirstapirest.controller.response.IdResponse;
import cl.duoc.cmartinez.myfirstapirest.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
  @Autowired
  private GreetingService service;
  @GetMapping
  public ResponseEntity<List<GreetingResponse>> getGreetings() {
    return ResponseEntity.ok(service.getGreetings());
  }

  @GetMapping("/{elementNumber}")
  public ResponseEntity<GreetingResponse> getGreeting(
          @PathVariable int elementNumber) {
    GreetingResponse found = service.getByPosition(elementNumber);

    if (found == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(found);
  }

  /*@PutMapping("/{elementNumber}")
  public ResponseEntity<GreetingResponse> putGreeting(
      @PathVariable int elementNumber, @RequestBody GreetingRequest request) {
    if (elementNumber >= 0 && elementNumber < greetingResponses.size()) {
      GreetingResponse element = greetingResponses.get(elementNumber);
      element.setMessage(request.getMessage());

      return ResponseEntity.ok(element);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<IdResponse> postGreeting(@RequestBody GreetingRequest request) {
    int nextId = greetingResponses.size() + 1;
    greetingResponses.add(new GreetingResponse(nextId, request.getMessage()));
    return ResponseEntity.status(HttpStatus.CREATED).body(new IdResponse(nextId));
  }

  @DeleteMapping("/{elementNumber}")
  public ResponseEntity<GreetingResponse> deleteGreeting(@PathVariable int elementNumber) {
    if (elementNumber >= 0 && elementNumber < greetingResponses.size()) {
      GreetingResponse element = greetingResponses.get(elementNumber);
      greetingResponses.remove(element);

      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }*/

  @GetMapping("/hello")
  public ResponseEntity<GreetingResponse> hello() {
    var response = new GreetingResponse();
    response.setMessage("Hello World");
    return ResponseEntity.ok(response);
  }

  @GetMapping("/hello-guest")
  public ResponseEntity<GreetingResponse> helloGuest(
      @RequestParam(value = "name") String name,
      @RequestParam(value = "lastname") String lastname) {
    var response = new GreetingResponse();
    response.setMessage("Hello " + name + " " + lastname);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/goodbye")
  public ResponseEntity<GreetingResponse> goodbye() {
    var response = new GreetingResponse();
    response.setMessage("Goodbye cruel World");
    return ResponseEntity.ok(response);
  }
}
