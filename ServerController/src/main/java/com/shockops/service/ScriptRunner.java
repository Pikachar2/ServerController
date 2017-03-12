package com.shockops.service;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import com.shockops.beans.ScriptInfo;
import com.shockops.common.*;

@Named
public class ScriptRunner {

	@Inject	private ScriptInfo scriptInfo;
	
	
	public int startServer(){
		int retval = 0;

//		ProcessBuilder pb = new ProcessBuilder("myshellScript.sh", "myArg1", "myArg2");
		//create builder
		ProcessBuilder pb = new ProcessBuilder(ConstVars.ARKSTARTSCRIPT);

		//add env vars
		
		//set running directory
		pb.directory(new File(ConstVars.SCRIPTDIR));
		pb.inheritIO();

		//start process
		try {
			System.out.println("Executing: " + pb.command());
			scriptInfo.setArkServer(pb.start());
			scriptInfo.setRunning(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retval = -1;
		}

		return retval;
	}
	
	public int stopServer(){
		int retval = 0;

/*		if(scriptInfo.getArkServer().isAlive()){
			scriptInfo.getArkServer().destroy();
			scriptInfo.setRunning(false);
		}
		else{
			retval = -1;	// already stopped
		}
		
		if(scriptInfo.getArkServer().exitValue() != 0){
			scriptInfo.getArkServer().destroyForcibly();
			scriptInfo.setRunning(false);
			retval = 1;	//force stopped
		}
		
*/		
		//create builder
		ProcessBuilder pb = new ProcessBuilder(ConstVars.ARKSTOPSCRIPT);

		//add env vars
		
		//set running directory
		pb.directory(new File(ConstVars.SCRIPTDIR));
		pb.inheritIO();
		//start process
		try {
			System.out.println("Executing: " + pb.command());
			scriptInfo.setArkServer(pb.start());
			scriptInfo.setRunning(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retval = -1;
		}

		return retval;
	}
	
	public int updateServer(){
		int retval = 0;

//		ProcessBuilder pb = new ProcessBuilder("myshellScript.sh", "myArg1", "myArg2");
		//create builder
		ProcessBuilder pb = new ProcessBuilder(ConstVars.ARKUPDATESCRIPT);

		//add env vars
		
		//set running directory
		pb.directory(new File(ConstVars.SCRIPTDIR));
		pb.inheritIO();

		//start process
		try {
			System.out.println("Executing: " + pb.command());
			scriptInfo.setArkServer(pb.start());
			scriptInfo.setRunning(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retval = -1;
		}

		return retval;
	}
	
}
