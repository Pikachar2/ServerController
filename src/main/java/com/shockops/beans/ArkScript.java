package com.shockops.beans;

import com.shockops.config.EnvironmentProperties;

public class ArkScript extends BaseScript {

    public ArkScript() {
        super(EnvironmentProperties.ARK_START_SCRIPT, EnvironmentProperties.ARK_STOP_SCRIPT,
                        EnvironmentProperties.ARK_UPDATE_SCRIPT, EnvironmentProperties.ARK_SCRIPT_DIR,
                        EnvironmentProperties.ARK_CREATE_SCRIPT, EnvironmentProperties.ARK_SAVE_SCRIPT,
                        EnvironmentProperties.ARK_KICK_SCRIPT);
    }

}
