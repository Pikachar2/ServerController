package com.shockops.service;

import com.shockops.beans.ArkData;
import com.shockops.beans.BaseScript;

public class StatusThread extends Thread{

	private BaseScript script;
	
	public StatusThread(BaseScript script) {
		super();
		this.script = script;
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
				new ScriptRunner().stopServer(script);
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
