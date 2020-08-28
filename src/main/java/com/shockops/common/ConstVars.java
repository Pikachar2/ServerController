package com.shockops.common;

public final class ConstVars {

    // public static final String SCRIPTDIR = "C:\\Users\\highi\\Desktop";
    public static final String SCRIPTDIR = "/home/zach/Scripts";
    public static final String ARKSCRIPTDIR = SCRIPTDIR + "/ArkScripts";
    public static final String WORKDIR = "/home/zach/Scripts/ArkScripts";
    public static final String ARK_SAVED_MAPS_DIR = "/home/zach/Servers/Ark_Server/ShooterGame/SavedMaps";

    // public static final String ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.bat";
    public static final String ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.sh";
    public static final String ARKSTOPSCRIPT = ARKSCRIPTDIR + "/arkStop.sh";
    public static final String ARKUPDATESCRIPT = ARKSCRIPTDIR + "/arkUpdate.sh";
    public static final String ARKCREATESCRIPT = ARKSCRIPTDIR + "/arkCreateMap.sh";
    public static final String ARKSAVESCRIPT = ARKSCRIPTDIR + "/arkSaveExport.sh";
    public static final String ARKKICKSCRIPT = ARKSCRIPTDIR + "/arkKickPlayer.sh";
    // public static final String ARKKICKSCRIPT = ARKSCRIPTDIR + "/arkKickPlayer.bat";
    public static final String ARK_MAP_FILE = ARKSCRIPTDIR + "/MapNames.txt";

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
    public static final String KICKED = "KICKED";

    // URLs
    public static final String ARKSERVERS_API_QUERY_URL = "https://arkservers.net/api/query/";
    public static final String THIS_SERVER_PORT = ":27015";

    // REGEX
    public static final String ARK_DATE_FILENAME_REGEX =
                    ".+(_P)?_\\d\\d\\.\\d\\d\\.\\d{4}+_\\d\\d\\.\\d\\d\\.\\d\\d\\.ark$";
}
