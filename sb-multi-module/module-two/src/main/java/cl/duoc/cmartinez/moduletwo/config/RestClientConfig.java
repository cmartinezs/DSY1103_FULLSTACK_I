package cl.duoc.cmartinez.moduletwo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    @Bean
    public RestClient helloWorldRestClient(RestClient.Builder builder) {
        return builder
                .baseUrl("http://localhost:8090")
                .build();
    }
}
