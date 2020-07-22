package com.shockops.common;

public final class ConstVars {

    // public static final String SCRIPTDIR = "C:\\";
    public static final String SCRIPTDIR = "/home/zach/Scripts";
    public static final String ARKSCRIPTDIR = SCRIPTDIR + "/ArkScripts";
    public static final String WORKDIR = "/home/zach/Scripts/ArkScripts";
    public static final String ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.sh";
    public static final String ARKSTOPSCRIPT = ARKSCRIPTDIR + "/arkStop.sh";
    public static final String ARKUPDATESCRIPT = ARKSCRIPTDIR + "/arkUpdate.sh";
    public static final String ARKCREATESCRIPT = ARKSCRIPTDIR + "/arkCreateMap.sh";
    public static final String ARKSAVESCRIPT = ARKSCRIPTDIR + "/arkSaveExport.sh";

    // SPECIFICS
    public static final String SERVERRUNNING = "Server is Running";
    public static final String SERVERUPDATING = "Server is Updating";
    public static final String EMPTY = "";

    // RETURN CODES
    public static final String STARTED = "STARTED";
    public static final String STARTING = "STARTING";
    public static final String STOPPED = "STOPPED";
    public static final String FAIL = "FAIL";
    public static final String GAMERUNNING = "GAME-RUNNING";
    public static final String PREVIOUSINSTANCE = "PREVIOUS-INSTANCE";
    public static final String UPDATING = "UPDATING";
    public static final String UPDATED = "UPDATED";
    public static final String NOINSTANCE = "NO-INSTANCE";
    public static final String SAVED = "SAVED";

    // URLs
    public static final String ARKSERVERS_API_QUERY_URL = "https://arkservers.net/api/query/";
    public static final String THIS_SERVER_PORT = ":27015";
}
