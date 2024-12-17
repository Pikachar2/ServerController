package com.shockops.beans;

public class PortContainer {
    private String gamePort;
    private String queryPort;
    private String rconPort;

    public PortContainer() {
        super();
    }

    public PortContainer(String gamePort, String queryPort, String rconPort) {
        super();
        this.gamePort = gamePort;
        this.queryPort = queryPort;
        this.rconPort = rconPort;
    }

    public String getGamePort() {
        return this.gamePort;
    }

    public String getQueryPort() {
        return this.queryPort;
    }

    public String getRconPort() {
        return this.rconPort;
    }

    public void setGamePort(String gamePort) {
        this.gamePort = gamePort;
    }

    public void setQueryPort(String queryPort) {
        this.queryPort = queryPort;
    }

    public void setRconPort(String rconPort) {
        this.rconPort = rconPort;
    }

    @Override
    public String toString() {
        return "PortContainer [gamePort=" + this.gamePort + ", queryPort=" + this.queryPort + ", rconPort="
                        + this.rconPort + "]";
    }

}
