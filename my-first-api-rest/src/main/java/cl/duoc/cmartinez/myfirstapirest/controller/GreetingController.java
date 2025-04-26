package cl.duoc.cmartinez.myfirstapirest.controller;

import cl.duoc.cmartinez.myfirstapirest.controller.request.GreetingRequest;
import cl.duoc.cmartinez.myfirstapirest.controller.response.GreetingResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    private List<GreetingResponse> greetingResponses;

    public GreetingController() {
        greetingResponses = new ArrayList<>();
        greetingResponses.add(new GreetingResponse(1, "Hello World"));
        greetingResponses.add(new GreetingResponse(2, "Bye World"));
        greetingResponses.add(new GreetingResponse(3, "My World"));
        greetingResponses.add(new GreetingResponse(4, "Your World"));
        greetingResponses.add(new GreetingResponse(5, "Cruel World"));
        greetingResponses.add(new GreetingResponse(6, "Sayonara World"));
        greetingResponses.add(new GreetingResponse(7, "Hi World"));
        greetingResponses.add(new GreetingResponse(8, "First World"));
        greetingResponses.add(new GreetingResponse(9, "Sad World"));
        greetingResponses.add(new GreetingResponse(10, "Pretty World"));
    }

    @GetMapping
    public ResponseEntity<List<GreetingResponse>> getGreetings() {
        return ResponseEntity.ok(greetingResponses);
    }

    @GetMapping("/{elementNumber}")
    public ResponseEntity<GreetingResponse> getGreeting(
            @PathVariable int elementNumber) {
        if(elementNumber >= 0 &&
                elementNumber < greetingResponses.size()) {
            return ResponseEntity.ok(
                    greetingResponses.get(elementNumber));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{elementNumber}")
    public ResponseEntity<GreetingResponse> putGreeting(
            @PathVariable int elementNumber,
            @RequestBody GreetingRequest request) {

        if(elementNumber >= 0 &&
                elementNumber < greetingResponses.size()) {

            GreetingResponse element = greetingResponses.get(elementNumber);
            element.setMessage(request.getMessage());

            return ResponseEntity.ok(element);
        }

        return ResponseEntity.notFound().build();
    }


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
