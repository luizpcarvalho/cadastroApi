package restproject.cadastroapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClientConfiguration {

    @Bean
    public RestTemplate createClient() {
        return new RestTemplate();
    }
}
