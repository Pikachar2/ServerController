package com.shockops.common;

import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import com.shockops.beans.PortContainer;
import com.shockops.collections.PortMap;
import com.shockops.collections.PortMapManager;
import com.shockops.enums.StatusEnum;

public class StatusLock {

    private static StatusEnum statusEnum = StatusEnum.OFFLINE;
    private static String statusMsg = statusEnum.assembleMessage();

    private static String sessionName = null;
    // private static List<String> mapNames = new ArrayList<>();
    private static PortMap portMap = new PortMap();

    public static void setStatusEnum(StatusEnum newStatus, String... args) {
        statusEnum = newStatus;
        statusMsg = statusEnum.assembleMessage((Object[]) args);
        // if (ArrayUtils.isEmpty(args)) {
        // sessionName = null;
        // portMap.clear();
        // } else if (args.length == 2) {
        // sessionName = args[0];
        // PortContainer ports = PortMapManager.getAvailablePorts(portMap);
        // portMap.put(args[1], ports.getGamePort(), ports.getQueryPort(), ports.getRconPort());
        // } else {
        // portMap.remove(args[0]);
        // }

        switch (newStatus) {
            case SPINNING_UP:
            case STARTING_SCRIPT:
            case CREATING:
                sessionName = args[0];
                PortContainer ports = PortMapManager.getAvailablePorts(portMap);
                portMap.put(args[1], ports.getGamePort(), ports.getQueryPort(), ports.getRconPort());
                break;
            case STOPPING:
                portMap.remove(args[0]);
                if (portMap.size() == 0) {
                    sessionName = null;
                    portMap.clear();
                }
            default:
                break;
        }
    }

    public static void setStatusEnum(StatusEnum newStatus, String arg, Set<String> args) {
        String[] argAr = args.toArray(new String[args.size()]);
        String[] argArray = {arg};
        argArray = ArrayUtils.addAll(argArray, argAr);
        setStatusEnum(newStatus, argArray);
    }

    public static StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public static String getSessionName() {
        return sessionName;
    }

    public static Set<String> getMapNames() {
        return portMap.getMapNames();
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
