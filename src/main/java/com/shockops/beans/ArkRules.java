package com.shockops.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArkRules {

	@JsonProperty("ALLOWDOWNLOADCHARS_i")
	private String ALLOWDOWNLOADCHARS_i;
	
	@JsonProperty("ALLOWDOWNLOADITEMS_i")
	private String ALLOWDOWNLOADITEMS_i;
	
	@JsonProperty("CUSTOMSERVERNAME_s")
	private String CUSTOMSERVERNAME_s;
	
	@JsonProperty("DayTime_s")
	private String DayTime_s;
	
	@JsonProperty("GameMode_s")
	private String GameMode_s;
	
	@JsonProperty("MATCHTIMEOUT_f")
	private String MATCHTIMEOUT_f;
	
	@JsonProperty("ModId_l")
	private String ModId_l;
	
	@JsonProperty("Networking_i")
	private String Networking_i;
	
	@JsonProperty("NUMOPENPUBCONN")
	private String NUMOPENPUBCONN;
	
	@JsonProperty("OFFICIALSERVER_i")
	private String OFFICIALSERVER_i;
	
	@JsonProperty("OWNINGID")
	private String OWNINGID;
	
	@JsonProperty("OWNINGNAME")
	private String OWNINGNAME;
	
	@JsonProperty("P2PADDR")
	private String P2PADDR;
	
	@JsonProperty("P2PPORT")
	private String P2PPORT;
	
	@JsonProperty("SEARCHKEYWORDS_s")
	private String SEARCHKEYWORDS_s;
	
	@JsonProperty("ServerPassword_b")
	private String ServerPassword_b;
	
	@JsonProperty("SERVERUSESBATTLEYE_b")
	private String SERVERUSESBATTLEYE_b;
	
	@JsonProperty("SESSIONFLAGS")
	private String SESSIONFLAGS;
	
	@JsonProperty("SESSIONISPVE_i")
	private String SESSIONISPVE_i;

	
	public ArkRules() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArkRules(String aLLOWDOWNLOADCHARS_i, String aLLOWDOWNLOADITEMS_i, String cUSTOMSERVERNAME_s,
			String dayTime_s, String gameMode_s, String mATCHTIMEOUT_f, String modId_l, String networking_i,
			String nUMOPENPUBCONN, String oFFICIALSERVER_i, String oWNINGID, String oWNINGNAME, String p2paddr,
			String p2pport, String sEARCHKEYWORDS_s, String serverPassword_b, String sERVERUSESBATTLEYE_b,
			String sESSIONFLAGS, String sESSIONISPVE_i) {
		super();
		ALLOWDOWNLOADCHARS_i = aLLOWDOWNLOADCHARS_i;
		ALLOWDOWNLOADITEMS_i = aLLOWDOWNLOADITEMS_i;
		CUSTOMSERVERNAME_s = cUSTOMSERVERNAME_s;
		DayTime_s = dayTime_s;
		GameMode_s = gameMode_s;
		MATCHTIMEOUT_f = mATCHTIMEOUT_f;
		ModId_l = modId_l;
		Networking_i = networking_i;
		NUMOPENPUBCONN = nUMOPENPUBCONN;
		OFFICIALSERVER_i = oFFICIALSERVER_i;
		OWNINGID = oWNINGID;
		OWNINGNAME = oWNINGNAME;
		P2PADDR = p2paddr;
		P2PPORT = p2pport;
		SEARCHKEYWORDS_s = sEARCHKEYWORDS_s;
		ServerPassword_b = serverPassword_b;
		SERVERUSESBATTLEYE_b = sERVERUSESBATTLEYE_b;
		SESSIONFLAGS = sESSIONFLAGS;
		SESSIONISPVE_i = sESSIONISPVE_i;
	}

	public String getALLOWDOWNLOADCHARS_i() {
		return ALLOWDOWNLOADCHARS_i;
	}

	public void setALLOWDOWNLOADCHARS_i(String aLLOWDOWNLOADCHARS_i) {
		ALLOWDOWNLOADCHARS_i = aLLOWDOWNLOADCHARS_i;
	}

	public String getALLOWDOWNLOADITEMS_i() {
		return ALLOWDOWNLOADITEMS_i;
	}

	public void setALLOWDOWNLOADITEMS_i(String aLLOWDOWNLOADITEMS_i) {
		ALLOWDOWNLOADITEMS_i = aLLOWDOWNLOADITEMS_i;
	}

	public String getCUSTOMSERVERNAME_s() {
		return CUSTOMSERVERNAME_s;
	}

	public void setCUSTOMSERVERNAME_s(String cUSTOMSERVERNAME_s) {
		CUSTOMSERVERNAME_s = cUSTOMSERVERNAME_s;
	}

	public String getDayTime_s() {
		return DayTime_s;
	}

	public void setDayTime_s(String dayTime_s) {
		DayTime_s = dayTime_s;
	}

	public String getGameMode_s() {
		return GameMode_s;
	}

	public void setGameMode_s(String gameMode_s) {
		GameMode_s = gameMode_s;
	}

	public String getMATCHTIMEOUT_f() {
		return MATCHTIMEOUT_f;
	}

	public void setMATCHTIMEOUT_f(String mATCHTIMEOUT_f) {
		MATCHTIMEOUT_f = mATCHTIMEOUT_f;
	}

	public String getModId_l() {
		return ModId_l;
	}

	public void setModId_l(String modId_l) {
		ModId_l = modId_l;
	}

	public String getNetworking_i() {
		return Networking_i;
	}

	public void setNetworking_i(String networking_i) {
		Networking_i = networking_i;
	}

	public String getNUMOPENPUBCONN() {
		return NUMOPENPUBCONN;
	}

	public void setNUMOPENPUBCONN(String nUMOPENPUBCONN) {
		NUMOPENPUBCONN = nUMOPENPUBCONN;
	}

	public String getOFFICIALSERVER_i() {
		return OFFICIALSERVER_i;
	}

	public void setOFFICIALSERVER_i(String oFFICIALSERVER_i) {
		OFFICIALSERVER_i = oFFICIALSERVER_i;
	}

	public String getOWNINGID() {
		return OWNINGID;
	}

	public void setOWNINGID(String oWNINGID) {
		OWNINGID = oWNINGID;
	}

	public String getOWNINGNAME() {
		return OWNINGNAME;
	}

	public void setOWNINGNAME(String oWNINGNAME) {
		OWNINGNAME = oWNINGNAME;
	}

	public String getP2PADDR() {
		return P2PADDR;
	}

	public void setP2PADDR(String p2paddr) {
		P2PADDR = p2paddr;
	}

	public String getP2PPORT() {
		return P2PPORT;
	}

	public void setP2PPORT(String p2pport) {
		P2PPORT = p2pport;
	}

	public String getSEARCHKEYWORDS_s() {
		return SEARCHKEYWORDS_s;
	}

	public void setSEARCHKEYWORDS_s(String sEARCHKEYWORDS_s) {
		SEARCHKEYWORDS_s = sEARCHKEYWORDS_s;
	}

	public String getServerPassword_b() {
		return ServerPassword_b;
	}

	public void setServerPassword_b(String serverPassword_b) {
		ServerPassword_b = serverPassword_b;
	}

	public String getSERVERUSESBATTLEYE_b() {
		return SERVERUSESBATTLEYE_b;
	}

	public void setSERVERUSESBATTLEYE_b(String sERVERUSESBATTLEYE_b) {
		SERVERUSESBATTLEYE_b = sERVERUSESBATTLEYE_b;
	}

	public String getSESSIONFLAGS() {
		return SESSIONFLAGS;
	}

	public void setSESSIONFLAGS(String sESSIONFLAGS) {
		SESSIONFLAGS = sESSIONFLAGS;
	}

	public String getSESSIONISPVE_i() {
		return SESSIONISPVE_i;
	}

	public void setSESSIONISPVE_i(String sESSIONISPVE_i) {
		SESSIONISPVE_i = sESSIONISPVE_i;
	}

}
