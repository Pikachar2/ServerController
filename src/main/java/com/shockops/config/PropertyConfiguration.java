package com.shockops.config;

import org.springframework.context.annotation.Configuration;

@Configuration
// @Service
// @DependsOn("PropertyConfiguration2")
public class PropertyConfiguration {

    // @Value("${ark.arkservers_api_query_url:https://arkservers.net/api/query/}")
    // private String arkServersApiQueryUrl;
    // @Value("${ark.server_port:27015}")
    // private String thisServerPort;
    //
    // // public static String SCRIPTDIR = "C:\\Users\\highi\\Desktop";
    // @Value("${ark.script.script_dir}")
    // private String scriptDir;
    // @Value("${ark.work_dir}")
    // private String workDir;
    // @Value("${ark.saved_maps.dir}")
    // private String arkSavedMapsDir;

    // URLs
    public static String ARKSERVERS_API_QUERY_URL;
    public static String THIS_SERVER_PORT;

    // public static String SCRIPTDIR = "C:\\Users\\highi\\Desktop";
    public static String SCRIPTDIR;
    public static String ARKSCRIPTDIR;
    public static String WORKDIR;
    public static String ARK_SAVED_MAPS_DIR;

    // public static String ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.bat";
    public static String ARKSTARTSCRIPT;// = ARKSCRIPTDIR + "/arkStartup.sh";
    public static String ARKSTOPSCRIPT;// = ARKSCRIPTDIR + "/arkStop.sh";
    public static String ARKUPDATESCRIPT;// = ARKSCRIPTDIR + "/arkUpdate.sh";
    public static String ARKCREATESCRIPT;// = ARKSCRIPTDIR + "/arkCreateMap.sh";
    public static String ARKSAVESCRIPT;// = ARKSCRIPTDIR + "/arkSaveExport.sh";
    public static String ARK_MAP_FILE;// = ARKSCRIPTDIR + "/MapNames.txt";

    // @PostConstruct
    // @Bean
    // public void setup() {
    // ARKSERVERS_API_QUERY_URL = arkServersApiQueryUrl;
    // THIS_SERVER_PORT = thisServerPort;
    //
    // SCRIPTDIR = scriptDir;
    // WORKDIR = workDir;
    // ARK_SAVED_MAPS_DIR = arkSavedMapsDir;
    // ARKSCRIPTDIR = SCRIPTDIR + "/ArkScripts";
    //
    // // Ark Control Scripts
    // ARKSTARTSCRIPT = ARKSCRIPTDIR + "/arkStartup.sh";
    // ARKSTOPSCRIPT = ARKSCRIPTDIR + "/arkStop.sh";
    // ARKUPDATESCRIPT = ARKSCRIPTDIR + "/arkUpdate.sh";
    // ARKCREATESCRIPT = ARKSCRIPTDIR + "/arkCreateMap.sh";
    // ARKSAVESCRIPT = ARKSCRIPTDIR + "/arkSaveExport.sh";
    // ARK_MAP_FILE = ARKSCRIPTDIR + "/MapNames.txt";
    //
    // System.out.println("ARK_MAP_FILE: " + ARK_MAP_FILE);
    // }

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
        ARK_MAP_FILE = ARKSCRIPTDIR + "/MapNames.txt";

        System.out.println("ARK_MAP_FILE: " + ARK_MAP_FILE);
    }
    // public PropertyConfiguration() {
    // super();
    // System.out.println("ARK_MAP_FILE super: " + ARK_MAP_FILE);
    // setup();
    // System.out.println("ARK_MAP_FILE super2: " + ARK_MAP_FILE);
    // }

}
