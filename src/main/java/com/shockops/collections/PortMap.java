package com.shockops.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.shockops.beans.PortContainer;

public class PortMap {
    // Look here for what ports are for what
    // https://ark.fandom.com/wiki/Dedicated_server_setup

    private HashMap<String, String> gamePortMap = new HashMap<>();
    private HashMap<String, String> queryPortMap = new HashMap<>();
    private HashMap<String, String> rconPortMap = new HashMap<>();

    public Set<String> put(String mapName, String gamePort, String queryPort, String rconPort) {
        Set<String> retSet = new HashSet<>();
        String oldGamePort = gamePortMap.putIfAbsent(mapName, gamePort);
        String oldQueryPort = queryPortMap.putIfAbsent(mapName, queryPort);
        String oldRconPort = rconPortMap.putIfAbsent(mapName, rconPort);
        retSet.add(oldGamePort);
        retSet.add(oldQueryPort);
        retSet.add(oldRconPort);
        return retSet;
    }

    public String getGamePort(String mapName) {
        return gamePortMap.get(mapName);
    }

    public String getQueryPort(String mapName) {
        return queryPortMap.get(mapName);
    }

    public String getRCONPort(String mapName) {
        return rconPortMap.get(mapName);
    }

    public PortContainer getPortsByMap(String mapName) {
        return new PortContainer(getGamePort(mapName), getQueryPort(mapName), getRCONPort(mapName));
    }

    public Set<String> remove(String mapName) {
        Set<String> retSet = new HashSet<>();
        String oldGamePort = gamePortMap.remove(mapName);
        String oldQueryPort = queryPortMap.remove(mapName);
        String oldRconPort = rconPortMap.remove(mapName);
        retSet.add(oldGamePort);
        retSet.add(oldQueryPort);
        retSet.add(oldRconPort);
        return retSet;
    }

    public Set<String> getMapNames() {
        return gamePortMap.keySet();
    }

    public void clear() {
        gamePortMap.clear();
        queryPortMap.clear();
        rconPortMap.clear();
    }

    public int size() {
        return gamePortMap.size();
    }

    HashMap<String, String> getGamePortMap() {
        return this.gamePortMap;
    }

    HashMap<String, String> getQueryPortMap() {
        return this.queryPortMap;
    }

    HashMap<String, String> getRconPortMap() {
        return this.rconPortMap;
    }

}
