package com.shockops.dto;

public class ArkConfigResponse {

    String configData;

    public ArkConfigResponse(String configData) {
        super();
        this.configData = configData;
    }

    public ArkConfigResponse() {
        super();
    }

    public String getConfigData() {
        return this.configData;
    }

    public void setConfigData(String configData) {
        this.configData = configData;
    }

    @Override
    public String toString() {
        return "arkConfigResponse [configData=" + this.configData + "]";
    }

}
