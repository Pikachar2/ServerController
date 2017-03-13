package com.shockops.service;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import com.shockops.beans.BaseScript;
import com.shockops.beans.ScriptInfo;
import com.shockops.common.ConstVars;

@Named
public class ScriptRunner {

	@Inject
	private ScriptInfo scriptInfo;

	public String startServer(BaseScript script) {
		String retval = ConstVars.STARTING;

		if (scriptInfo.isRunning()) {
			if (scriptInfo.getStatus().equals(ConstVars.SERVERUPDATING)) {
				return ConstVars.UPDATING;
			}
			return ConstVars.PREVIOUSINSTANCE;
		}

		// ProcessBuilder pb = new ProcessBuilder("myshellScript.sh", "myArg1",
		// "myArg2");
		// create builder
		ProcessBuilder pb = new ProcessBuilder(script.getStartScript());

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
			e.printStackTrace();
			retval = ConstVars.FAIL;
		}

		return retval;
	}

	public String updateServer(BaseScript script) {
		String retval = ConstVars.UPDATED;

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

}
