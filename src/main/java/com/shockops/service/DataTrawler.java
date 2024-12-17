package com.shockops.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.shockops.beans.ArkData;
import com.shockops.config.PropertyConfiguration;
import com.shockops.deserializer.CustomBooleanDeserializer;

@Service
@DependsOn({"initEnvVars"})
public class DataTrawler {
    @Autowired
    PropertyConfiguration propertyConfiguration;

    private ArkData data;
    private static String url;
    private HttpHeaders headers;
    RestTemplate restTemplate;
    HttpEntity<String> entity;

    public DataTrawler() {
        super();
        this.data = new ArkData();
        this.restTemplate = new RestTemplate();
        initEntity();
    }

    @PostConstruct
    public void setup() {
        url = propertyConfiguration.getArkServersApiQueryUrl();
        System.out.println("Trawler-URL POSTCONSTRUCT: " + url);
    }

    public DataTrawler(String json) {
        this.data = convertJsonToData(json);
    }

    public void initHeader() {
        this.headers = new HttpHeaders();
        this.headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        this.headers.add("user-agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    }

    public void initEntity() {
        initHeader();
        this.entity = new HttpEntity<>("parameters", headers);
    }

    public ArkData exchangeAndConvert() {
        return convertJsonToData(executeExchange());
    }

    private String executeExchange() {
        String completeUrl = url + propertyConfiguration.getArkServerApiKey();
        // System.out.println("Trawler-URL executeExchange: " + completeUrl);

        ResponseEntity<String> res = restTemplate.exchange(completeUrl, HttpMethod.GET, entity, String.class);
        // System.out.println("Trawler-URL executeExchange -- call completed.");
        String responseBody = res.getBody().toString();
        // System.out.println("Trawler-URL executeExchange -- responseBody -> String.");
        return responseBody;
    }

    public ArkData convertJsonToData(String json) {
        if (json.equals("null")) {
            this.data = null;
            return null;
        }

        ArkData newData = null;
        // Use JSONMapper
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(boolean.class, new CustomBooleanDeserializer());
        mapper.registerModule(module);
        try {
            newData = mapper.readValue(json, ArkData.class);
        } catch (JsonProcessingException ex) {
            System.out.println("Trawler-URL convertJsonToData -- Failed to map to JSON.");
            ex.printStackTrace();
        }

        this.data = newData;
        // System.out.println("Trawler-URL convertJsonToData -- converted to JSON.");
        return newData;
    }

    public ArkData getData() {
        return data;
    }

    public void setData(ArkData data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        DataTrawler.url = url;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HttpEntity<String> getEntity() {
        return entity;
    }

    public void setEntity(HttpEntity<String> entity) {
        this.entity = entity;
    }

}
