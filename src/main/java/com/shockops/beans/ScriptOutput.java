package com.shockops.beans;

public class ScriptOutput {

    private int exitCode = 0;
    private String statusMessage;

    public ScriptOutput() {
        super();
    }

    public ScriptOutput(int exitCode, String statusMessage) {
        super();
        this.exitCode = exitCode;
        this.statusMessage = statusMessage;
    }

    public int getExitCode() {
        return this.exitCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}
