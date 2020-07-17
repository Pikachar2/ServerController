package com.shockops.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArkInfo {

    @JsonProperty("Protocol")
    private String protocol;

    @JsonProperty("HostName")
    private String hostName;

    @JsonProperty("Map")
    private String map;

    @JsonProperty("ModDir")
    private String modDir;

    @JsonProperty("ModDesc")
    private String modDesc;

    @JsonProperty("AppID")
    private String appID;

    @JsonProperty("Players")
    private String players;

    @JsonProperty("MaxPlayers")
    private String maxPlayers;

    @JsonProperty("Bots")
    private String bots;

    @JsonProperty("Dedicated")
    private String dedicated;

    @JsonProperty("Os")
    private String os;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("Secure")
    private String secure;

    @JsonProperty("Version")
    private String version;

    @JsonProperty("ExtraDataFlags")
    private String extraDataFlags;

    @JsonProperty("GamePort")
    private String gamePort;

    @JsonProperty("SteamID")
    private String steamID;

    @JsonProperty("GameTags")
    private String gameTags;

    @JsonProperty("GameID")
    private String gameID;

    public ArkInfo() {
        super();
    }

    public ArkInfo(String protocol, String hostName, String map, String modDir, String modDesc, String appID,
                    String players, String maxPlayers, String bots, String dedicated, String os, String password,
                    String secure, String version, String extraDataFlags, String gamePort, String steamID,
                    String gameTags, String gameID) {
        super();
        this.protocol = protocol;
        this.hostName = hostName;
        this.map = map;
        this.modDir = modDir;
        this.modDesc = modDesc;
        this.appID = appID;
        this.players = players;
        this.maxPlayers = maxPlayers;
        this.bots = bots;
        this.dedicated = dedicated;
        this.os = os;
        this.password = password;
        this.secure = secure;
        this.version = version;
        this.extraDataFlags = extraDataFlags;
        this.gamePort = gamePort;
        this.steamID = steamID;
        this.gameTags = gameTags;
        this.gameID = gameID;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getModDir() {
        return modDir;
    }

    public void setModDir(String modDir) {
        this.modDir = modDir;
    }

    public String getModDesc() {
        return modDesc;
    }

    public void setModDesc(String modDesc) {
        this.modDesc = modDesc;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public String getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(String maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public String getBots() {
        return bots;
    }

    public void setBots(String bots) {
        this.bots = bots;
    }

    public String getDedicated() {
        return dedicated;
    }

    public void setDedicated(String dedicated) {
        this.dedicated = dedicated;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecure() {
        return secure;
    }

    public void setSecure(String secure) {
        this.secure = secure;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getExtraDataFlags() {
        return extraDataFlags;
    }

    public void setExtraDataFlags(String extraDataFlags) {
        this.extraDataFlags = extraDataFlags;
    }

    public String getGamePort() {
        return gamePort;
    }

    public void setGamePort(String gamePort) {
        this.gamePort = gamePort;
    }

    public String getSteamID() {
        return steamID;
    }

    public void setSteamID(String steamID) {
        this.steamID = steamID;
    }

    public String getGameTags() {
        return gameTags;
    }

    public void setGameTags(String gameTags) {
        this.gameTags = gameTags;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

}
