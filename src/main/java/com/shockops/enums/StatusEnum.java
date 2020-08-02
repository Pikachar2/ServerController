package com.shockops.enums;

import java.text.MessageFormat;

public enum StatusEnum {
    OFFLINE("Server is OFFLINE", false),
    CREATING("CREATING session: {0}, map: {1}...", true),
    CREATED("Session: {0}, map: {1} CREATED", false),
    STARTING("STARTING session: {0}, map: {1}...", true),
    STARTED("Session: {0}, map: {1} currently running", false),
    SAVING("SAVING Session: {0}, map: {1}...", true),
    SAVED("", false),
    STOPPING("STOPPING: Session Session: {0}, map: {1}", true),
    STOPPED("Session: {0}, map: {1} STOPPED", false),
    UPDATING("UPDATING SERVER...", true),
    UPDATED("Server is now UPDATED!", false),
    CONFIG_SAVING("SAVING CONFIG", true),
    CONFIG_SAVED("Config saved for: Session: {0}, map: {1}", false);

    private String statusMsg;
    private Boolean isInProgress = false;

    private StatusEnum(String statusMsg, Boolean isInProgress) {
        this.statusMsg = statusMsg;
        this.isInProgress = isInProgress;
    }

    public String assembleMessage(Object... args) {
        return MessageFormat.format(this.statusMsg, args);
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public Boolean getIsInProgress() {
        return this.isInProgress;
    }

    public void setIsInProgress(Boolean isInProgress) {
        this.isInProgress = isInProgress;
    }

}
