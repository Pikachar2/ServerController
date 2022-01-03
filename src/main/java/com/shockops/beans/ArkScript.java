package com.shockops.beans;

import com.shockops.config.EnvironmentProperties;

public class ArkScript extends BaseScript {

    public ArkScript() {
        super(EnvironmentProperties.ARKSTARTSCRIPT, EnvironmentProperties.ARKSTOPSCRIPT,
                        EnvironmentProperties.ARKUPDATESCRIPT, EnvironmentProperties.ARKSCRIPTDIR,
                        EnvironmentProperties.ARKCREATESCRIPT, EnvironmentProperties.ARKSAVESCRIPT);
    }

}
