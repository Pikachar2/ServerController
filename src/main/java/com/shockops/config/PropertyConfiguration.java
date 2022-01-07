package com.shockops.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfiguration implements InitializingBean {

    @Value("${ark.arkservers_api_query_url:https://arkservers.net/api/query/}")
    private String arkServersApiQueryUrl;

    @Value("${ark.game_port}")
    private String gamePort;
    @Value("${ark.query_port}")
    private String queryPort;
    @Value("${ark.rcon.port}")
    private String rconPort;

    // public static String SCRIPTDIR = "C:\\Users\\highi\\Desktop";
    @Value("${ark.script.script_dir}")
    private String scriptDir;
    @Value("${ark.work_dir}")
    private String workDir;
    @Value("${ark.saved_maps.dir}")
    private String arkSavedMapsDir;

    @Value("${ark.max_maps_running}")
    private Integer maxMapsRunning;

    @Bean
    public void initEnvVars() {
        EnvironmentProperties.initEnvVars(arkServersApiQueryUrl, gamePort, queryPort, rconPort, scriptDir, workDir,
                        arkSavedMapsDir, maxMapsRunning);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initEnvVars();
    }
}
