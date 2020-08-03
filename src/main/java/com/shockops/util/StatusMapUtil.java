package com.shockops.util;

import org.apache.commons.lang3.StringUtils;

import com.shockops.common.StatusLock;
import com.shockops.enums.StatusEnum;

public class StatusMapUtil {

    public static void statusCheckAndUpdateOffline(String line, String... args) {
        // If matches script text
        if ("".equals(line)) {
            StatusLock.setStatusEnum(StatusEnum.OFFLINE, args);
        }
    }

    public static void statusCheckAndUpdateStarted(String line, String... args) {
        // If matches script text
        if (StringUtils.contains(line, "Server Started!")) {
            StatusLock.setStatusEnum(StatusEnum.STARTED, args);
        } else if (StringUtils.contains(line, "Server already started!!")) {
            StatusLock.setStatusEnum(StatusEnum.STARTED, args);
        }
    }

    public static void statusCheckAndUpdateCreated(String line, String... args) {
        // If matches script text
        if (StringUtils.contains(line, "Map Saved!")) {
            StatusLock.setStatusEnum(StatusEnum.CREATED, args);
        } else if (StringUtils.contains(line, "Server Started!")) {
            StatusLock.setStatusEnum(StatusEnum.STARTED, args);
        }
    }

    public static void statusCheckAndUpdateStopped(String line, String... args) {
        // If matches script text
        if (StringUtils.contains(line, "Map Saved!")) {
            StatusLock.setStatusEnum(StatusEnum.SAVED, args);
        } else if (StringUtils.contains(line, "Server is now stopped.")) {
            StatusLock.setStatusEnum(StatusEnum.STOPPED, args);
        }
    }

    public static void statusCheckAndUpdateSaved(String line, String... args) {
        // If matches script text
        if (StringUtils.contains(line, "Map Saved!")) {
            StatusLock.setStatusEnum(StatusEnum.SAVED, args);
        }
    }

    public static void statusCheckAndUpdateUpdatedServer(String line, String... args) {
        // If matches script text
        if (StringUtils.contains(line, "Update is finished!")) {
            StatusLock.setStatusEnum(StatusEnum.UPDATED, args);
        } else if (StringUtils.contains(line, "Server is started!! Shutdown server then update.")) {
            StatusLock.setStatusEnum(StatusEnum.STARTED, args);
        }
    }
}
