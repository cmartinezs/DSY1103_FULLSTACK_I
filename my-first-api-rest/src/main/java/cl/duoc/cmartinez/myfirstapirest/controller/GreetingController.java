package cl.duoc.cmartinez.myfirstapirest.controller;

import cl.duoc.cmartinez.myfirstapirest.controller.response.GreetingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @GetMapping("/hello")
    public ResponseEntity<GreetingResponse> hello() {
        var response = new GreetingResponse();
        response.setGreeting("Hello World");
        return ResponseEntity.ok(response);
    }
    // http://localhost:8080/greetings/hello-guest?name=Carlos&lastname=Martinez
    @GetMapping("/hello-guest")
    public ResponseEntity<GreetingResponse> helloGuest(@RequestParam(required = false, value = "name") String name, @RequestParam(required = false, value = "lastname") String lastname) {
        var response = new GreetingResponse();
        response.setGreeting("Hello " + name + " " + lastname);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/goodbye")
    public ResponseEntity<GreetingResponse> goodbye() {
        var response = new GreetingResponse();
        response.setGreeting("Goodbye cruel World");
        return ResponseEntity.ok(response);
    }


}
