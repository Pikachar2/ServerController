package com.shockops.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shockops.beans.ArkData;
import com.shockops.beans.ArkScript;
import com.shockops.beans.TransferInfo;

@RestController
public class ArkController extends ServerController {

	@RequestMapping(value = "/ark/start/{sessionName}", method = RequestMethod.GET, produces = "application/json")
	public TransferInfo startArkServer(@PathVariable(value="sessionName") String sessionName) {
		// TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.startServer(script, sessionName));

		return retval;
	}

	@RequestMapping(value = "/ark/createmap/{sessionName}/{mapName}", method = RequestMethod.GET, produces = "application/json")
	public TransferInfo createMapAndStartArkServer(@PathVariable(value="sessionName") String sessionName, @PathVariable(value="mapName") String mapName) {
		// TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.createMapAndStartServer(script, sessionName, mapName));

		return retval;
	}

//	@RequestMapping(value = "/ark/start", method = RequestMethod.GET, produces = "application/json")
//	public TransferInfo startArkServer() {
//		// TODO call bash script
//		ArkScript script = new ArkScript();
//		TransferInfo retval = new TransferInfo(scriptRunner.startServer(script));
//
//		return retval;
//	}

	@RequestMapping(value = "/ark/stop", method = RequestMethod.GET, produces = "application/json")
	public TransferInfo stopArkServer() {
		// TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.stopServer(script));

		return retval;
	}

	@RequestMapping(value = "/ark/update", method = RequestMethod.GET, produces = "application/json")
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
