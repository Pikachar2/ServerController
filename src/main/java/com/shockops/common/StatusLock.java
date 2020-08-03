package com.shockops.common;

import org.apache.commons.lang3.ArrayUtils;

import com.shockops.enums.StatusEnum;

public class StatusLock {

    private static StatusEnum statusEnum = StatusEnum.OFFLINE;
    private static String statusMsg = statusEnum.assembleMessage();

    private static String sessionName = null;
    private static String mapName = null;

    public static void setStatusEnum(StatusEnum newStatus, String... args) {
        statusEnum = newStatus;
        statusMsg = statusEnum.assembleMessage((Object[]) args);
        if (ArrayUtils.isEmpty(args)) {
            sessionName = null;
            mapName = null;
        } else {
            sessionName = args[0];
            mapName = args[1];
        }
    }

    public static StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public static String getSessionName() {
        return sessionName;
    }

    public static String getMapName() {
        return mapName;
    }

    public static Boolean isOffline() {
        return statusEnum == StatusEnum.OFFLINE;
    }

    public static Boolean isInProgress() {
        return statusEnum.getIsInProgress();
    }

    public static String getStatusMsg() {
        return statusMsg;
    }

    public static Boolean isRunning() {
        return statusEnum.isRunning();
    }

}
