package com.shockops.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shockops.beans.TransferInfo;

@RestController
public class ArkController extends ServerController{
	
	@RequestMapping(value = "/ark/start", method = RequestMethod.GET, produces = "application/json")
	public TransferInfo startArkServer(){
		//TODO call bash script
		TransferInfo retval = new TransferInfo(scriptRunner.startServer());
		
		return retval;
	}
	
	@RequestMapping(value = "/ark/stop", method = RequestMethod.GET, produces = "application/json")
	public TransferInfo stopArkServer(){
		//TODO call bash script
		TransferInfo retval = new TransferInfo(scriptRunner.stopServer());
		
		return retval;
	}
	
	@RequestMapping(value = "/ark/update", method = RequestMethod.GET, produces = "application/json")
	public TransferInfo updateArkServer(){
		//TODO call bash script
		TransferInfo retval = new TransferInfo(scriptRunner.updateServer());
		
		return retval;
	}
	
}
