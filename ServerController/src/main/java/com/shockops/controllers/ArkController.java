package com.shockops.controllers;

import java.util.Arrays;

import javax.annotation.PostConstruct;

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
import com.shockops.common.ConstVars;
import com.shockops.service.DataTrawler;

@RestController
public class ArkController extends ServerController {

	@RequestMapping(value = "/ark/start", method = RequestMethod.PUT, produces = "application/json")
	public TransferInfo startArkServer() {
		// TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.startServer(script));

		return retval;
	}

	@RequestMapping(value = "/ark/stop", method = RequestMethod.PUT, produces = "application/json")
	public TransferInfo stopArkServer() {
		// TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.stopServer(script));

		return retval;
	}

	@RequestMapping(value = "/ark/update", method = RequestMethod.PUT, produces = "application/json")
	public TransferInfo updateArkServer() {
		// TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.updateServer(script));

		return retval;
	}

	@RequestMapping(value = "/ark/status", method = RequestMethod.GET, produces = "application/json")
	public TransferInfo arkOnline() {
		// TODO need to check arkServers to see if arkserver is actually up and
		// running.
		/*
		 * This needs to have it's own controller, not really a script to run,
		 * but needs to access an api?
		 */
		// TODO Link for help on getting server info
		// https://ark-servers.net/help/api/

		ArkData data = dataTrawler.exchangeAndConvert();

		if (data == null || data.equals(null)) {
			return new TransferInfo("Offline");
		}
		// TODO check the data to see if the server is in fact up and running

		return new TransferInfo("Online");
	}

}
