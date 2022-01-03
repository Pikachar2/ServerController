package com.shockops.service;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shockops.beans.ArkData;
import com.shockops.config.EnvironmentProperties;

@Service
public class DataTrawler {
    @Autowired
    EnvironmentProperties propertyConfiguration;

    private ArkData data;
    private static String url;
    private HttpHeaders headers;
    RestTemplate restTemplate;
    HttpEntity<String> entity;

    public DataTrawler() {
        super();
        this.data = new ArkData();
        url = EnvironmentProperties.ARKSERVERS_API_QUERY_URL;
        System.out.println("Trawler-URL: " + url);
        this.restTemplate = new RestTemplate();
        initEntity();
    }

    // @PostConstruct
    public void setup() {
        url = EnvironmentProperties.ARKSERVERS_API_QUERY_URL;
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
        String completeUrl = url + IPAddressService.MY_IP;
        // System.out.println("Trawler-URL executeExchange: " + url);

        ResponseEntity<String> res = restTemplate.exchange(completeUrl, HttpMethod.GET, entity, String.class);
        String responseBody = res.getBody().toString();
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
        try {
            newData = mapper.readValue(json, ArkData.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.data = newData;
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
