package com.shockops.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvironmentProperties {

    // URLs
    public static String ARKSERVERS_API_QUERY_URL;
    public static String THIS_SERVER_PORT;

    // public static String SCRIPTDIR = "C:\\Users\\highi\\Desktop";
    public static String SCRIPTDIR;
    public static String ARKSCRIPTDIR;
    public static String WORKDIR;
    public static String ARK_SAVED_MAPS_DIR;

    // public static String ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.bat";
    public static String ARKSTARTSCRIPT;
    public static String ARKSTOPSCRIPT;
    public static String ARKUPDATESCRIPT;
    public static String ARKCREATESCRIPT;
    public static String ARKSAVESCRIPT;
    public static String ARKKICKSCRIPT;
    // public static final String ARKKICKSCRIPT = ARKSCRIPTDIR + "/arkKickPlayer.bat";
    public static String ARK_MAP_FILE;

    public static void initEnvVars(String arkServersApiQueryUrl, String thisServerPort, String scriptDir,
                    String workDir, String arkSavedMapsDir) {
        ARKSERVERS_API_QUERY_URL = arkServersApiQueryUrl;
        THIS_SERVER_PORT = thisServerPort;

        SCRIPTDIR = scriptDir;
        WORKDIR = workDir;
        ARK_SAVED_MAPS_DIR = arkSavedMapsDir;
        ARKSCRIPTDIR = SCRIPTDIR + "/ArkScripts";

        // Ark Control Scripts
        ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.sh";
        ARKSTOPSCRIPT = ARKSCRIPTDIR + "/arkStop.sh";
        ARKUPDATESCRIPT = ARKSCRIPTDIR + "/arkUpdate.sh";
        ARKCREATESCRIPT = ARKSCRIPTDIR + "/arkCreateMap.sh";
        ARKSAVESCRIPT = ARKSCRIPTDIR + "/arkSaveExport.sh";
        ARKKICKSCRIPT = ARKSCRIPTDIR + "/arkKickPlayer.sh";
        ARK_MAP_FILE = ARKSCRIPTDIR + "/MapNames.txt";

        System.out.println("ARK_MAP_FILE: " + ARK_MAP_FILE);
    }

}
