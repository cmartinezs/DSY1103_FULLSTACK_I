package cl.duoc.cmartinez.myfirstapirest.repository;

import cl.duoc.cmartinez.myfirstapirest.controller.response.GreetingResponse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GreetingRespository {

    private List<GreetingResponse> greetingResponses;

    public GreetingRespository() {
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

    public List<GreetingResponse> getAll() {
        return greetingResponses;
    }
}
