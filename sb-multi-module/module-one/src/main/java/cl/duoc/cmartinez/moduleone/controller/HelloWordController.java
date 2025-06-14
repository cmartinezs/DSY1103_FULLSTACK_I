package cl.duoc.cmartinez.moduleone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWordController {
    @RequestMapping
    public String helloWorld() {
        return "Hello World from Module One!";
    }
}

