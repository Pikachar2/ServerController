package com.shockops.service;

import java.io.IOException;
import java.util.Arrays;

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
import com.shockops.common.ConstVars;

@Service
public class DataTrawler {

    private ArkData data;
    private String url;
    private HttpHeaders headers;
    RestTemplate restTemplate;
    HttpEntity<String> entity;

    public DataTrawler() {
        super();
        this.data = new ArkData();
        this.url = ConstVars.ARKSERVERS_API_QUERY_URL;
        this.restTemplate = new RestTemplate();
        initEntity();
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
        String completeUrl = this.url + IPAddressService.MY_IP;

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
        this.url = url;
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
