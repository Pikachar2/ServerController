package com.shockops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shockops.config.EnvironmentProperties;

@Service
public class IPAddressService {
    // private static final String IP_CHECK_ADDRESS = "http://bot.whatismyipaddress.com/";
    @Value("${system.ip_check_address}")
    private String IP_CHECK_ADDRESS;// = "http://checkip.amazonaws.com/";

    @Autowired
    private RestTemplate restTemplate;

    public static String MY_IP = "";

    public String getMyIp() {
        // System.out.println("IP_CHECK_ADDRESS: " + IP_CHECK_ADDRESS);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(IP_CHECK_ADDRESS, String.class);
        String retVal = responseEntity.getBody().trim();
        MY_IP = retVal + ":" + EnvironmentProperties.THIS_SERVER_PORT;
        return retVal;
    }
}
