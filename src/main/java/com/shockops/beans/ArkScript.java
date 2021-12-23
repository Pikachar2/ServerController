package com.shockops.beans;

import com.shockops.config.PropertyConfiguration;

public class ArkScript extends BaseScript {

    public ArkScript() {
        super(PropertyConfiguration.ARKSTARTSCRIPT, PropertyConfiguration.ARKSTOPSCRIPT,
                        PropertyConfiguration.ARKUPDATESCRIPT, PropertyConfiguration.ARKSCRIPTDIR,
                        PropertyConfiguration.ARKCREATESCRIPT, PropertyConfiguration.ARKSAVESCRIPT);
    }

}
