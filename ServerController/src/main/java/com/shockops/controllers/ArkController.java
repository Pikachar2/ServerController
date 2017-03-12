package com.shockops.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shockops.beans.ArkScript;
import com.shockops.beans.BaseScript;
import com.shockops.beans.TransferInfo;
import com.shockops.common.ConstVars;

@RestController
public class ArkController extends ServerController{
	
	@RequestMapping(value = "/ark/start", method = RequestMethod.GET, produces = "application/json")
	public TransferInfo startArkServer(){
		//TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.startServer(script));

		return retval;
	}
	
	@RequestMapping(value = "/ark/stop", method = RequestMethod.GET, produces = "application/json")
	public TransferInfo stopArkServer(){
		//TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.stopServer(script));
		
		return retval;
	}
	
	@RequestMapping(value = "/ark/update", method = RequestMethod.GET, produces = "application/json")
	public TransferInfo updateArkServer(){
		//TODO call bash script
		ArkScript script = new ArkScript();
		TransferInfo retval = new TransferInfo(scriptRunner.updateServer(script));
		
		return retval;
	}
	
}
