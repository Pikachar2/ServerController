package com.shockops.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvironmentProperties {

    public static final String SCRIPT_SUFFIX = getScriptSuffix();

    // URLs
    public static String ARKSERVERS_API_QUERY_URL;
    public static String GAME_PORT;
    public static String QUERY_PORT;
    public static String RCON_PORT;

    // public static String SCRIPTDIR = "C:\\Users\\highi\\Desktop";
    public static String SCRIPT_DIR;
    public static String ARK_SCRIPT_DIR;
    public static String WORK_DIR;
    public static String ARK_SAVED_MAPS_DIR;

    // public static String ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.bat";
    public static String ARK_START_SCRIPT;
    public static String ARK_STOP_SCRIPT;
    public static String ARK_UPDATE_SCRIPT;
    public static String ARK_CREATE_SCRIPT;
    public static String ARK_SAVE_SCRIPT;
    public static String ARK_KICK_SCRIPT;

    public static String ARK_MAP_FILE;

    public static Integer MAX_MAPS_RUNNING;

    public static void initEnvVars(String arkServersApiQueryUrl, String gamePort, String queryPort, String rconPort,
                    String scriptDir, String workDir, String arkSavedMapsDir, Integer maxMapsRunning) {
        ARKSERVERS_API_QUERY_URL = arkServersApiQueryUrl;
        QUERY_PORT = queryPort;
        GAME_PORT = gamePort;
        RCON_PORT = rconPort;

        SCRIPT_DIR = scriptDir;
        WORK_DIR = workDir;
        ARK_SAVED_MAPS_DIR = arkSavedMapsDir;
        ARK_SCRIPT_DIR = SCRIPT_DIR + "/ArkScripts";

        // Ark Control Scripts
        ARK_START_SCRIPT = ARK_SCRIPT_DIR + "/arkStartup" + SCRIPT_SUFFIX;
        ARK_STOP_SCRIPT = ARK_SCRIPT_DIR + "/arkStop" + SCRIPT_SUFFIX;
        ARK_UPDATE_SCRIPT = ARK_SCRIPT_DIR + "/arkUpdate" + SCRIPT_SUFFIX;
        ARK_CREATE_SCRIPT = ARK_SCRIPT_DIR + "/arkCreateMap" + SCRIPT_SUFFIX;
        ARK_SAVE_SCRIPT = ARK_SCRIPT_DIR + "/arkSaveExport" + SCRIPT_SUFFIX;
        ARK_KICK_SCRIPT = ARK_SCRIPT_DIR + "/arkKickPlayer" + SCRIPT_SUFFIX;
        ARK_MAP_FILE = ARK_SCRIPT_DIR + "/MapNames.txt";

        System.out.println("ARKSTARTSCRIPT: " + ARK_START_SCRIPT);

        MAX_MAPS_RUNNING = maxMapsRunning;
    }

    private static String getScriptSuffix() {
        String os = SystemUtils.OS_NAME;

        System.out.println("Operating System: " + os);
        if (StringUtils.contains(os, "Windows")) {
            return ".bat";
        }
        return "" + SCRIPT_SUFFIX;
    }

}
