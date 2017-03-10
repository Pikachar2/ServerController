package com.shockops.beans;

import javax.inject.Named;

@Named
public class ScriptInfo {

	private boolean running = false;
	private Process arkServer;

	public Process getArkServer() {
		return arkServer;
	}

	public synchronized void setArkServer(Process arkServer) {
		this.arkServer = arkServer;
	}

	public boolean isRunning() {
		return running;
	}

	public synchronized void setRunning(boolean running) {
		this.running = running;
	}
	
} 
