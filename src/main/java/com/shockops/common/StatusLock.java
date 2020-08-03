package com.shockops.common;

import com.shockops.enums.StatusEnum;

public class StatusLock {

    private static StatusEnum statusEnum = StatusEnum.OFFLINE;
    private static String statusMsg = "";

    public static void setStatusEnum(StatusEnum newStatus, String... args) {
        statusEnum = newStatus;
        statusMsg = statusEnum.assembleMessage((Object[]) args);
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
}
