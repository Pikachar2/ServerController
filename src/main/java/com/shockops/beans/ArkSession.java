package com.shockops.beans;

import java.util.Set;

public class ArkSession {

    String sessionName;
    Set<String> mapNames;

    public ArkSession() {
        super();
    }

    public ArkSession(String sessionName, Set<String> mapNames) {
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

    public Set<String> getMapNames() {
        return this.mapNames;
    }

    public void setMapNames(Set<String> mapNames) {
        this.mapNames = mapNames;
    }

    @Override
    public String toString() {
        return "ArkSession [sessionName=" + this.sessionName + ", mapNames=" + this.mapNames + "]";
    }

}
