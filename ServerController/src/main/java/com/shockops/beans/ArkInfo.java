package com.shockops.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArkInfo {

	private String hostName;
	private String map;
	private String players;
	private String maxPlayers;
	
	public ArkInfo(){
		//empty...
	}
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String getPlayers() {
		return players;
	}
	public void setPlayers(String players) {
		this.players = players;
	}
	public String getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(String maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	@Override
	public String toString() {
		return "info{hostName=" + hostName + ", map=" + map + ", players=" + players + ", maxPlayers=" + maxPlayers
				+ "}";
	}
	
}
