package gg.ujm.pennynd1me.config;

import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class HttpClientConfig {

    private final Environment environment;

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(50)
                .setMaxConnPerRoute(10)
                .build();

        factory.setHttpClient(httpClient);
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(5000);

        return new RestTemplate(factory);
    }

    @Bean
    public HttpHeaders httpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36");
        httpHeaders.add("X-Riot-Token", environment.getProperty("riot.api.token"));

        return httpHeaders;
    }
}