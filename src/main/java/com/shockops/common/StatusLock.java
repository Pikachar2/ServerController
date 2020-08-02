package com.shockops.common;

import com.shockops.enums.StatusEnum;

public class StatusLock {

    public static StatusEnum statusEnum = StatusEnum.OFFLINE;

    public static Boolean isOffline() {
        return statusEnum == StatusEnum.OFFLINE;
    }

    public static Boolean isInProgress() {
        return statusEnum.getIsInProgress();
    }
}
