package com.shockops.enums;

import java.text.MessageFormat;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum StatusEnum {
    OFFLINE("Server is OFFLINE", false),
    CREATING("CREATING session: {0}, map: {1}...", true),
    CREATED("Session: {0}, map: {1} CREATED", false),
    STARTING_SCRIPT("STARTING session: {0}, map: {1}...", true),
    SPINNING_UP("STARTING session: {0}, map: {1}...", true),
    STARTED("Session: {0}, map: {1} currently running", false),
    SAVING("SAVING Current Session...", true),
    // SAVED("", false),
    STOPPING("STOPPING Session...", true),
    STOPPED_AND_EXPORTING("Session STOPPED. Exporting map data...", true),
    UPDATING("UPDATING SERVER...", true),
    UPDATED("Server is now UPDATED!", false),
    CONFIG_SAVING("SAVING CONFIG...", true),
    CONFIG_SAVED("Config saved for: Session: {0}, map: {1}", false);

    private String statusMsg;
    private Boolean isInProgress = false;

    private static final Set<StatusEnum> runningStatus = Stream.of(SPINNING_UP, STARTED).collect(Collectors.toSet());

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

    public Boolean getIsInProgress() {
        return this.isInProgress;
    }

    public Boolean isRunning() {
        return this.getIsInProgress() || runningStatus.contains(this);
    }

}
