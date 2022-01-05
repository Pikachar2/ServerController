package com.shockops.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.shockops.enums.StatusEnum;

public class StatusLock {

    private static StatusEnum statusEnum = StatusEnum.OFFLINE;
    private static String statusMsg = statusEnum.assembleMessage();

    private static String sessionName = null;
    private static List<String> mapNames = new ArrayList<>();

    public static void setStatusEnum(StatusEnum newStatus, String... args) {
        statusEnum = newStatus;
        statusMsg = statusEnum.assembleMessage((Object[]) args);
        if (ArrayUtils.isEmpty(args)) {
            sessionName = null;
            mapNames = null;
        } else if (args.length == 2) {
            sessionName = args[0];
            mapNames.add(args[1]);
        } else {
            mapNames.remove(args[0]);
        }
    }

    public static void setStatusEnum(StatusEnum newStatus, String arg, List<String> args) {
        String[] argArray = {arg + args.toArray()};
        setStatusEnum(newStatus, argArray);
    }

    public static StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public static String getSessionName() {
        return sessionName;
    }

    public static List<String> getMapNames() {
        return mapNames;
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
