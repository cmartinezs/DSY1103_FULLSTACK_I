package cl.duoc.cmartinez.moduleone.controller;

import cl.duoc.cmartinez.moduleone.controller.response.HelloWorldResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWordController {
  @GetMapping
  public String helloWorld() {
    return "Hello World from Module One!";
  }

  @GetMapping("/re")
  public ResponseEntity<HelloWorldResponse> helloWorldRE() {
    return ResponseEntity.ok(new HelloWorldResponse("Hello World RE from Module One!"));
  }
}
