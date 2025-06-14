package cl.duoc.cmartinez.moduletwo.apiclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class HelloWorldTwoApiClient {
    @Autowired
    @Qualifier("helloWorldRestClient")
    private RestClient restClient;

    public String getHelloWorld() {
        return restClient
                .get()
                .uri(u -> u.path("/hello-world").build())
                .retrieve()
                .body(String.class);
    }
}
