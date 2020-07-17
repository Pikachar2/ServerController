package com.shockops.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ArkData {

    @JsonProperty("info")
	 private ArkInfo info;
    @JsonProperty("players")
	 private List<ArkPlayer> players;
    @JsonProperty("rules")
	 private ArkRules rules;
    
    
    
	public ArkData(ArkInfo info, List<ArkPlayer> players, ArkRules rules) {
		super();
		this.info = info;
		this.players = players;
		this.rules = rules;
	}
	public ArkData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArkInfo getInfo() {
		return info;
	}
	public void setInfo(ArkInfo info) {
		this.info = info;
	}
	public List<ArkPlayer> getPlayers() {
		return players;
	}
	public void setPlayers(List<ArkPlayer> players) {
		this.players = players;
	}
	public ArkRules getRules() {
		return rules;
	}
	public void setRules(ArkRules rules) {
		this.rules = rules;
	}
	 
	 
	 
}
