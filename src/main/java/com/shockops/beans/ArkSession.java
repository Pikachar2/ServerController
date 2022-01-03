package com.shockops.beans;

import java.util.List;

public class ArkSession {

    String sessionName;
    List<String> mapNames;

    public ArkSession() {
        super();
    }

    public ArkSession(String sessionName, List<String> mapNames) {
        super();
        this.sessionName = sessionName;
        this.mapNames = mapNames;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public List<String> getMapNames() {
        return this.mapNames;
    }

    public void setMapNames(List<String> mapNames) {
        this.mapNames = mapNames;
    }

    @Override
    public String toString() {
        return "ArkSession [sessionName=" + this.sessionName + ", mapNames=" + this.mapNames + "]";
    }

}
