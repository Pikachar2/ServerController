package com.shockops.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.shockops.beans.PortContainer;
import com.shockops.config.EnvironmentProperties;

public class PortMapManager {
    // https://ark.fandom.com/wiki/Dedicated_server_setup

    private static final Integer gamePortIncrement = 2;
    private static final Integer queryPortIncrement = 1;
    private static final Integer rconPortIncrement = 1;

    private static final Integer MAX_MAPS_RUNNING = EnvironmentProperties.MAX_MAPS_RUNNING;
    private static final Integer BASE_GAME_PORT = Integer.valueOf(EnvironmentProperties.GAME_PORT);
    private static final Integer BASE_QUERY_PORT = Integer.valueOf(EnvironmentProperties.QUERY_PORT);
    private static final Integer BASE_RCON_PORT = Integer.valueOf(EnvironmentProperties.RCON_PORT);

    public static PortContainer getAvailablePorts(PortMap portMap) {
        PortContainer ports = new PortContainer();
        String gamePort = manageGamePorts(portMap.getGamePortMap());
        String queryPort = manageQueryPorts(portMap.getQueryPortMap());
        String rconPort = manageRconPorts(portMap.getRconPortMap());
        ports.setGamePort(gamePort);
        ports.setQueryPort(queryPort);
        ports.setRconPort(rconPort);

        return ports;
    }

    private static String manageGamePorts(Map<String, String> gamePortMap) {
        List<Integer> values = convertStringCollectionToIntegerList(gamePortMap.values());
        // get lowest value between game BASE_GAME_PORT and BASE_GAME_PORT + ((MAXMAPS -1) *
        // gamePortIncrement)
        // Calculate max port
        Integer maxPort = BASE_GAME_PORT + ((MAX_MAPS_RUNNING - 1) * gamePortIncrement);
        Set<Integer> possiblePorts = createListOfPossiblePorts(BASE_GAME_PORT, maxPort, gamePortIncrement);
        Integer portVal = searchForPort(possiblePorts, values);
        if (portVal == null) {
            throw new NullPointerException();
        }
        return portVal.toString();
    }

    private static String manageQueryPorts(Map<String, String> queryPortMap) {
        List<Integer> values = convertStringCollectionToIntegerList(queryPortMap.values());
        // get lowest value between game BASE_QUERY_PORT and BASE_QUERY_PORT + ((MAXMAPS -1) *
        // queryPortIncrement)
        // Calculate max port
        Integer maxPort = BASE_QUERY_PORT + ((MAX_MAPS_RUNNING - 1) * queryPortIncrement);
        Set<Integer> possiblePorts = createListOfPossiblePorts(BASE_QUERY_PORT, maxPort, queryPortIncrement);
        Integer portVal = searchForPort(possiblePorts, values);
        if (portVal == null) {
            throw new NullPointerException();
        }
        return portVal.toString();
    }

    private static String manageRconPorts(Map<String, String> rconPortMap) {
        List<Integer> values = convertStringCollectionToIntegerList(rconPortMap.values());
        // get lowest value between game BASE_RCON_PORT and BASE_RCON_PORT + ((MAXMAPS -1) *
        // rconPortIncrement)
        // Calculate max port
        Integer maxPort = BASE_RCON_PORT + ((MAX_MAPS_RUNNING - 1) * rconPortIncrement);
        Set<Integer> possiblePorts = createListOfPossiblePorts(BASE_RCON_PORT, maxPort, rconPortIncrement);
        Integer portVal = searchForPort(possiblePorts, values);
        if (portVal == null) {
            throw new NullPointerException();
        }
        return portVal.toString();
    }

    private static Integer searchForPort(Set<Integer> possiblePorts, List<Integer> values) {
        for (Integer possiblePort : possiblePorts) {
            if (!values.contains(possiblePort)) {
                return possiblePort;
            }
        }
        return null;
    }

    private static Set<Integer> createListOfPossiblePorts(Integer basePort, Integer maxPort, Integer increment) {
        Set<Integer> possiblePorts = new HashSet<>();
        for (int i = basePort; i <= maxPort; i += increment) {
            possiblePorts.add(i);
        }
        return possiblePorts;
    }

    private static List<Integer> convertStringCollectionToIntegerList(Collection<String> str) {
        return str.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }

}
