package com.shockops.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArkController extends ServerController{
	
	@RequestMapping(value = "/ark/start", method = RequestMethod.GET, produces = "application/json")
	public String startArkServer(){
		String retval = "";
		//TODO call bash script
		
		scriptRunner.startServer();
		retval = "Success";
		return retval;
	}
	
}
