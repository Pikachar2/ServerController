package com.shockops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    private static final int TIMEOUT = 15000;

    /**
     *
     * @return RestTemplate with timeout configuration
     */
    @Bean
    public RestTemplate basicRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(TIMEOUT);
        return new RestTemplate(factory);
    }

    /**
     *
     * @return HttpHeaders HTTP headers configuration.
     */
    @Bean
    public HttpHeaders basicHeaders() {
        HttpHeaders headers = new HttpHeaders();
        return headers;
    }
}
