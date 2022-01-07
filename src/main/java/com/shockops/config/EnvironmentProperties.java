package com.shockops.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvironmentProperties {

    public static final String SCRIPT_SUFFIX = getScriptSuffix();

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
        ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup" + SCRIPT_SUFFIX;
        ARKSTOPSCRIPT = ARKSCRIPTDIR + "/arkStop" + SCRIPT_SUFFIX;
        ARKUPDATESCRIPT = ARKSCRIPTDIR + "/arkUpdate" + SCRIPT_SUFFIX;
        ARKCREATESCRIPT = ARKSCRIPTDIR + "/arkCreateMap" + SCRIPT_SUFFIX;
        ARKSAVESCRIPT = ARKSCRIPTDIR + "/arkSaveExport" + SCRIPT_SUFFIX;
        ARKKICKSCRIPT = ARKSCRIPTDIR + "/arkKickPlayer" + SCRIPT_SUFFIX;
        ARK_MAP_FILE = ARKSCRIPTDIR + "/MapNames.txt";

        System.out.println("ARKSTARTSCRIPT: " + ARKSTARTSCRIPT);
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
