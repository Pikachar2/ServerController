package com.shockops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shockops.common.ConstVars;

@Service
public class IPAddressService {
    private static final String IP_CHECK_ADDRESS = "http://bot.whatismyipaddress.com/";

    @Autowired
    private RestTemplate restTemplate;

    public static String MY_IP = "";

    public String getMyIp() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(IP_CHECK_ADDRESS, String.class);
        String retVal = responseEntity.getBody();
        MY_IP = retVal + ConstVars.THIS_SERVER_PORT;
        return retVal;
    }
}
