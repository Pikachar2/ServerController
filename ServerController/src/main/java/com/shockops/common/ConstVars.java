package com.shockops.common;

public final class ConstVars {

//	public static final String SCRIPTDIR = "C:\\";
	public static final String SCRIPTDIR = "/home/zach/Scripts";
	public static final String ARKSCRIPTDIR = SCRIPTDIR + "/ArkScripts";
	public static final String WORKDIR = "/home/zach/Scripts/ArkScripts";
	public static final String ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.sh";
	public static final String ARKSTOPSCRIPT = ARKSCRIPTDIR + "/arkStop.sh";
	public static final String ARKUPDATESCRIPT = ARKSCRIPTDIR + "/arkUpdate.sh";
	
	
	//SPECIFICS 
	public static final String SERVERRUNNING = "Server is Running";
	public static final String SERVERUPDATING = "Server is Updating";
	public static final String EMPTY = "";
	
	
	//RETURN CODES
	public static final String STARTED = "STARTED";
	public static final String STARTING = "STARTING";
	public static final String STOPPED = "STOPPED";
	public static final String FAIL = "FAIL";
	public static final String GAMERUNNING = "GAME-RUNNING";
	public static final String PREVIOUSINSTANCE = "PREVIOUS-INSTANCE";
	public static final String UPDATING = "UPDATING";
	public static final String UPDATED = "UPDATED";
	public static final String NOINSTANCE = "NO-INSTANCE";
	
	//URLs
	public static final String ARKSERVERAPI = "https://arkservers.net/api/query/";
	public static final String ARKSERVERIP = "98.169.137.229:27015";
	public static final String ARKSERVERADDR = ARKSERVERAPI + ARKSERVERIP;
}
