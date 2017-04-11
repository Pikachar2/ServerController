package com.shockops.service;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import com.shockops.beans.ArkData;
import com.shockops.beans.BaseScript;
import com.shockops.beans.ScriptInfo;
import com.shockops.common.ConstVars;

@Named
public class ScriptRunner extends Thread{

	@Inject
	private ScriptInfo scriptInfo;
	private BaseScript bScript;

	public String startServer(BaseScript script, String sessionName) {
		String retval = ConstVars.STARTING;
		this.bScript = script;
		
		if (scriptInfo.isRunning()) {
			if (scriptInfo.getStatus().equals(ConstVars.SERVERUPDATING)) {
				return ConstVars.UPDATING;
			}
			else if(new DataTrawler().exchangeAndConvert() == null){
				return ConstVars.STARTING;
			}
			return ConstVars.PREVIOUSINSTANCE;
		}

		// ProcessBuilder pb = new ProcessBuilder("myshellScript.sh", "myArg1",
		// "myArg2");
		// create builder
		ProcessBuilder pb = new ProcessBuilder(script.getStartScript(), sessionName);

		// add env vars

		// set running directory
		pb.directory(new File(ConstVars.SCRIPTDIR));
		pb.inheritIO();

		// start process
		try {
			System.out.println("Executing: " + pb.command());
			scriptInfo.setArkServer(pb.start());
			setStatus(true, ConstVars.SERVERRUNNING);
		} catch (IOException e) {
			e.printStackTrace();
			retval = ConstVars.FAIL;
		}

		return retval;
	}

	public String createMapAndStartServer(BaseScript script, String sessionName, String mapName) {
		String retval = ConstVars.STARTING;
		this.bScript = script;
		
		if (scriptInfo.isRunning()) {
			if (scriptInfo.getStatus().equals(ConstVars.SERVERUPDATING)) {
				return ConstVars.UPDATING;
			}
			else if(new DataTrawler().exchangeAndConvert() == null){
				return ConstVars.STARTING;
			}
			return ConstVars.PREVIOUSINSTANCE;
		}

		// ProcessBuilder pb = new ProcessBuilder("myshellScript.sh", "myArg1",
		// "myArg2");
		// create builder
		ProcessBuilder pb = new ProcessBuilder(script.getCreateScript(), sessionName, mapName);

		// add env vars

		// set running directory
		pb.directory(new File(ConstVars.SCRIPTDIR));
		pb.inheritIO();

		// start process
		try {
			System.out.println("Executing: " + pb.command());
			scriptInfo.setArkServer(pb.start());
			setStatus(true, ConstVars.SERVERRUNNING);
		} catch (IOException e) {
			e.printStackTrace();
			retval = ConstVars.FAIL;
		}

		return retval;
	}

	public String stopServer(BaseScript script) {
		String retval = ConstVars.STOPPED;

		if (!scriptInfo.isRunning()) {
			return ConstVars.NOINSTANCE;
		}

		// TODO check if people are in the game

		// create builder
		ProcessBuilder pb = new ProcessBuilder(script.getStopScript());

		// set running directory
		pb.directory(new File(ConstVars.SCRIPTDIR));
		pb.inheritIO();
		// start process
		try {
			System.out.println("Executing: " + pb.command());
			scriptInfo.setArkServer(pb.start());
			setStatus(false, ConstVars.EMPTY);
		} catch (IOException e) {
			System.out.println("something broke");
			e.printStackTrace();
			retval = ConstVars.FAIL;
		}

		System.out.println("just before returning...");
//		new StatusThread(script).start();
		return retval;
	}

	public String updateServer(BaseScript script) {
		String retval = ConstVars.UPDATED;
		this.bScript = script;

		if (scriptInfo.isRunning()) {
			if (scriptInfo.getStatus().equals(ConstVars.SERVERUPDATING)) {
				return ConstVars.UPDATING;
			}
			return ConstVars.GAMERUNNING;
		}

		// create builder
		ProcessBuilder pb = new ProcessBuilder(script.getUpdateScript());

		// set running directory
		pb.directory(new File(ConstVars.SCRIPTDIR));
		pb.inheritIO();

		// start process
		try {
			System.out.println("Executing: " + pb.command());
			scriptInfo.setArkServer(pb.start());
			setStatus(true, ConstVars.SERVERUPDATING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retval = ConstVars.FAIL;
		}

		try {
			scriptInfo.getArkServer().waitFor();
			setStatus(false, ConstVars.EMPTY);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Waiting failed...");
			
		}

		return retval;
	}

	private void setStatus(boolean isRunning, String status) {
		scriptInfo.setRunning(isRunning);
		scriptInfo.setStatus(status);
	}
	
	//Thread stuff
	public void run() {
		DataTrawler dt = new DataTrawler();
		ArkData data = dt.exchangeAndConvert();
		
		while(true){
			data = dt.exchangeAndConvert();
			try {
				sleep(300000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(data == null || data.equals(null)){
				//server is offline
				break;
			}else if(data.getPlayers().size() == 0 || data.getInfo().getPlayers().length() == 0){
				//if nobody is online
				//turn off server
				stopServer(bScript);
				//leave loop/join thread
				break;
			}
			
		}
		try {
			this.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
