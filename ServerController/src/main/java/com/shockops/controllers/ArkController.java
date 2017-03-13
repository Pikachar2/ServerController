package com.shockops.controllers;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shockops.beans.ArkData;
import com.shockops.beans.ArkScript;
import com.shockops.beans.TransferInfo;

@RestController
public class ArkController extends ServerController{
	
	@RequestMapping(value = "/ark/start", method = RequestMethod.PUT, produces = "application/json")
	public TransferInfo startArkServer(){
		//TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.startServer(script));

		return retval;
	}
	
	@RequestMapping(value = "/ark/stop", method = RequestMethod.PUT, produces = "application/json")
	public TransferInfo stopArkServer(){
		//TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.stopServer(script));
		
		return retval;
	}
	
	@RequestMapping(value = "/ark/update", method = RequestMethod.PUT, produces = "application/json")
	public TransferInfo updateArkServer(){
		//TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.updateServer(script));
		
		return retval;
	}
	
	@RequestMapping(value = "/ark/online", method = RequestMethod.GET, produces = "application/json")
	public TransferInfo arkOnline(){
		//TODO need to check arkServers to see if arkserver is actually up and running.
		/* This needs to have it's own controller, not really a script to run, but needs to access an api?
		 * 
		 * 
		 */
		//TODO Link for help on getting server info
//		https://ark-servers.net/help/api/
		//endpoint for server
//		https://arkservers.net/api/query/98.169.137.229:27015
		RestTemplate restTemplate = new RestTemplate();
		ArkData data;
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        String url = "https://arkservers.net/api/query/98.169.137.229:27015";
        ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        
        String responseBody = res.getBody().toString();
        
        data = new ArkData(responseBody);
        //TODO check the data to see if the server is in fact up and running
        
        TransferInfo retval = new TransferInfo(data.toString());
				
		return retval;
	}
	
	
}
