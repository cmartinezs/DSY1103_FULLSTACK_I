package cl.duoc.cmartinez.moduletwo.apiclient;

import cl.duoc.cmartinez.moduletwo.apiclient.response.HelloWorldResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
public class HelloWorldOneApiClient {
  @Autowired
  @Qualifier("helloWorldRestClient")
  private RestClient restClient;

  public String getHelloWorld() {
    return restClient.get()
            .uri(u -> u.path("/hello-world").build())
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError,
                    (req, res) -> {
              // algo para hacer cuando sea 400
                      log.error(res.getStatusText());
                    })
            .body(String.class);
  }

  public HelloWorldResponse getHelloWorldRE() {
    return restClient.get()
            .uri(u -> u.path("/hello-world/re").build())
            .retrieve()
            .toEntity(HelloWorldResponse.class)
            .getBody();
  }
}
