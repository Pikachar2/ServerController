package com.shockops.beans;

import org.springframework.stereotype.Component;

@Component
public class ScriptInfo {

    private boolean running = false;
    private Process arkServer;
    private String status = "";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Process getArkServer() {
        return arkServer;
    }

    public synchronized void setArkServer(Process arkServer) {
        this.arkServer = arkServer;
    }

    public boolean isRunning() {
        return running;
    }

    public synchronized void setRunning(boolean running) {
        this.running = running;
    }

}
