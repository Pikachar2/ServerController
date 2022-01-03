package com.shockops.util;

import org.apache.commons.lang3.StringUtils;

import com.shockops.common.StatusLock;
import com.shockops.enums.StatusEnum;

public class StatusMapUtil {

    public static void statusCheckAndUpdateStarted(String line, String... args) {
        // If matches script text
        if (StringUtils.contains(line, "Server Started!")) {
            StatusLock.setStatusEnum(StatusEnum.SPINNING_UP, args);
        }
    }

    public static void statusCheckAndUpdateCreated(String line, String... args) {
        // If matches script text
        if (StringUtils.contains(line, "Map Saved!")) {
            StatusLock.setStatusEnum(StatusEnum.CREATED, args);
        } else if (StringUtils.contains(line, "Server Started!")) {
            StatusLock.setStatusEnum(StatusEnum.SPINNING_UP, args);
        }
    }

    public static void statusCheckAndUpdateStopped(String line, String... args) {
        // If matches script text
        if (StringUtils.contains(line, "Map Saved!")) {
            StatusLock.setStatusEnum(StatusEnum.OFFLINE, args);
        } else if (StringUtils.contains(line, "Server is now stopped.")) {
            StatusLock.setStatusEnum(StatusEnum.STOPPED_AND_EXPORTING, args);
        }
    }

    public static void statusCheckAndUpdateSaved(String line, String... args) {
        // If matches script text
        if (StringUtils.contains(line, "Map Saved!")) {
            StatusLock.setStatusEnum(StatusEnum.STARTED, StatusLock.getSessionName(), StatusLock.getMapName());
        }
    }

    public static void statusCheckAndUpdateUpdatedServer(String line, String... args) {
        // If matches script text
        if (StringUtils.contains(line, "Update is finished!")) {
            StatusLock.setStatusEnum(StatusEnum.OFFLINE, args);
        } else if (StringUtils.contains(line, "Server is started!! Shutdown server then update.")) {
            StatusLock.setStatusEnum(StatusEnum.SPINNING_UP, args);
        }
    }

    public static void statusCheckAndUpdateKicked(String line, String... args) {
        // Stub
    }

}
