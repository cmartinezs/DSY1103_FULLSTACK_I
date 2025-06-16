package cl.duoc.cmartinez.moduletwo.controller;

import cl.duoc.cmartinez.moduletwo.apiclient.HelloWorldOneApiClient;
import cl.duoc.cmartinez.moduletwo.apiclient.response.HelloWorldResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWordController {
  @Autowired private HelloWorldOneApiClient apiClient;

  @GetMapping
  public String helloWorld() {
    return "Hello World from Module Two!";
  }

  @GetMapping("/consume-remote")
  public String greet() {
    return apiClient.getHelloWorld();
  }

  @GetMapping("/consume-remote/re")
  public ResponseEntity<HelloWorldResponse> greetRE() {
    return ResponseEntity.ok(apiClient.getHelloWorldRE());
  }
}
