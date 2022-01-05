package com.shockops.dto;

import java.util.List;

public class ArkStatusResponse {

    private String status;
    private String currentSessionName;
    private List<String> mapNames;

    public ArkStatusResponse(String status, String currentSessionName, List<String> mapNames) {
        super();
        this.status = status;
        this.currentSessionName = currentSessionName;
        this.mapNames = mapNames;
    }

    public ArkStatusResponse() {
        super();
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentSessionName() {
        return this.currentSessionName;
    }

    public List<String> getMapNames() {
        return this.mapNames;
    }

    public void setCurrentSessionName(String currentSessionName) {
        this.currentSessionName = currentSessionName;
    }

    public void setMapNames(List<String> mapNames) {
        this.mapNames = mapNames;
    }

    @Override
    public String toString() {
        return "ArkStatusResponse [status=" + this.status + ", currentSessionName=" + this.currentSessionName
                        + ", mapNames=" + this.mapNames + "]";
    }

}
