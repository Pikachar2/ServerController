package com.shockops.beans;

public class BaseScript {

    private String startScript;
    private String stopScript;
    private String updateScript;
    private String scriptDirectory;
    private String createScript;
    private String saveScript;

    public BaseScript(String startScript, String stopScript, String updateScript, String scriptDirectory,
                    String createScript, String saveScript) {
        super();
        this.startScript = startScript;
        this.stopScript = stopScript;
        this.updateScript = updateScript;
        this.scriptDirectory = scriptDirectory;
        this.createScript = createScript;
        this.saveScript = saveScript;
    }

    public String getScriptDirectory() {
        return scriptDirectory;
    }

    public void setScriptDirectory(String scriptDirectory) {
        this.scriptDirectory = scriptDirectory;
    }

    public String getStartScript() {
        return startScript;
    }

    public void setStartScript(String startScript) {
        this.startScript = startScript;
    }

    public String getStopScript() {
        return stopScript;
    }

    public void setStopScript(String stopScript) {
        this.stopScript = stopScript;
    }

    public String getUpdateScript() {
        return updateScript;
    }

    public void setUpdateScript(String updateScript) {
        this.updateScript = updateScript;
    }

    public String getCreateScript() {
        return createScript;
    }

    public void setCreateScript(String createScript) {
        this.createScript = createScript;
    }

    public String getSaveScript() {
        return this.saveScript;
    }

    public void setSaveScript(String saveScript) {
        this.saveScript = saveScript;
    }

}
