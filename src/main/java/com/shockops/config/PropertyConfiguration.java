package com.shockops.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class PropertyConfiguration {

    // URLs
    public static String ARKSERVERS_API_QUERY_URL;
    public static String THIS_SERVER_PORT;

    // public static String SCRIPTDIR = "C:\\Users\\highi\\Desktop";
    public static String SCRIPTDIR;
    public static String ARKSCRIPTDIR;
    public static String WORKDIR;
    public static String ARK_SAVED_MAPS_DIR;

    // public static String ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.bat";
    public static String ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.sh";
    public static String ARKSTOPSCRIPT = ARKSCRIPTDIR + "/arkStop.sh";
    public static String ARKUPDATESCRIPT = ARKSCRIPTDIR + "/arkUpdate.sh";
    public static String ARKCREATESCRIPT = ARKSCRIPTDIR + "/arkCreateMap.sh";
    public static String ARKSAVESCRIPT = ARKSCRIPTDIR + "/arkSaveExport.sh";
    public static String ARK_MAP_FILE = ARKSCRIPTDIR + "/MapNames.txt";

    @Value("${ark.arkservers_api_query_url:https://arkservers.net/api/query/}")
    public void setARKSERVERS_API_QUERY_URL(String aRKSERVERS_API_QUERY_URL) {
        ARKSERVERS_API_QUERY_URL = aRKSERVERS_API_QUERY_URL;
    }

    @Value("${ark.server_port::27015}")
    public void setTHIS_SERVER_PORT(String tHIS_SERVER_PORT) {
        THIS_SERVER_PORT = tHIS_SERVER_PORT;
    }

    @Value("${ark.script.script_dir}")
    public void setSCRIPTDIR(String sCRIPTDIR) {
        SCRIPTDIR = sCRIPTDIR;
    }

    @Value("${ark.work_dir}")
    public void setWORKDIR(String wORKDIR) {
        WORKDIR = wORKDIR;
    }

    @Value("${ark.saved_maps.dir}")
    public void setARK_SAVED_MAPS_DIR(String aRK_SAVED_MAPS_DIR) {
        ARK_SAVED_MAPS_DIR = aRK_SAVED_MAPS_DIR;
    }

    @PostConstruct
    public void setup() {
        ARKSCRIPTDIR = SCRIPTDIR + "/ArkScripts";

        // Ark Control Scripts
        ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.sh";
        ARKSTOPSCRIPT = ARKSCRIPTDIR + "/arkStop.sh";
        ARKUPDATESCRIPT = ARKSCRIPTDIR + "/arkUpdate.sh";
        ARKCREATESCRIPT = ARKSCRIPTDIR + "/arkCreateMap.sh";
        ARKSAVESCRIPT = ARKSCRIPTDIR + "/arkSaveExport.sh";
        ARK_MAP_FILE = ARKSCRIPTDIR + "/MapNames.txt";

    }

}
