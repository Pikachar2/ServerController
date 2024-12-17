package com.shockops.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArkData {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("port")
    private String port;
    @JsonProperty("private")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private boolean isPrivate;
    @JsonProperty("password")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private boolean isPassword;
    @JsonProperty("query_port")
    private String queryPort;
    @JsonProperty("location")
    private String location;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("map")
    private String map;
    @JsonProperty("is_online")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private boolean isOnline;
    @JsonProperty("players")
    private int players;
    @JsonProperty("maxplayers")
    private int maxPlayers;
    @JsonProperty("version")
    private String version;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("uptime")
    private String uptime;
    @JsonProperty("score")
    private String score;
    @JsonProperty("rank")
    private String rank;
    @JsonProperty("votes")
    private String votes;
    @JsonProperty("favorited")
    private String favorited;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("url")
    private String url;
    @JsonProperty("last_check")
    private String lastCheck;
    @JsonProperty("last_online")
    private String lastOnline;

    public ArkData() {
        super();
    }

    public ArkData(String id, String name, String address, String port, boolean isPrivate, boolean isPassword,
                    String queryPort, String location, String hostname, String map, boolean isOnline, int players,
                    int maxPlayers, String version, String platform, String uptime, String score, String rank,
                    String votes, String favorited, String comments, String url, String lastCheck, String lastOnline) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.port = port;
        this.isPrivate = isPrivate;
        this.isPassword = isPassword;
        this.queryPort = queryPort;
        this.location = location;
        this.hostname = hostname;
        this.map = map;
        this.isOnline = isOnline;
        this.players = players;
        this.maxPlayers = maxPlayers;
        this.version = version;
        this.platform = platform;
        this.uptime = uptime;
        this.score = score;
        this.rank = rank;
        this.votes = votes;
        this.favorited = favorited;
        this.comments = comments;
        this.url = url;
        this.lastCheck = lastCheck;
        this.lastOnline = lastOnline;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPort() {
        return this.port;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isPassword() {
        return this.isPassword;
    }

    public String getQueryPort() {
        return this.queryPort;
    }

    public String getLocation() {
        return this.location;
    }

    public String getHostname() {
        return this.hostname;
    }

    public String getMap() {
        return this.map;
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public int getPlayers() {
        return this.players;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public String getVersion() {
        return this.version;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getUptime() {
        return this.uptime;
    }

    public String getScore() {
        return this.score;
    }

    public String getRank() {
        return this.rank;
    }

    public String getVotes() {
        return this.votes;
    }

    public String getFavorited() {
        return this.favorited;
    }

    public String getComments() {
        return this.comments;
    }

    public String getUrl() {
        return this.url;
    }

    public String getLastCheck() {
        return this.lastCheck;
    }

    public String getLastOnline() {
        return this.lastOnline;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public void setPassword(boolean isPassword) {
        this.isPassword = isPassword;
    }

    public void setQueryPort(String queryPort) {
        this.queryPort = queryPort;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public void setFavorited(String favorited) {
        this.favorited = favorited;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLastCheck(String lastCheck) {
        this.lastCheck = lastCheck;
    }

    public void setLastOnline(String lastOnline) {
        this.lastOnline = lastOnline;
    }

    @Override
    public String toString() {
        return "ArkData [id=" + this.id + ", name=" + this.name + ", address=" + this.address + ", port=" + this.port
                        + ", isPrivate=" + this.isPrivate + ", isPassword=" + this.isPassword + ", queryPort="
                        + this.queryPort + ", location=" + this.location + ", hostname=" + this.hostname + ", map="
                        + this.map + ", isOnline=" + this.isOnline + ", players=" + this.players + ", maxPlayers="
                        + this.maxPlayers + ", version=" + this.version + ", platform=" + this.platform + ", uptime="
                        + this.uptime + ", score=" + this.score + ", rank=" + this.rank + ", votes=" + this.votes
                        + ", favorited=" + this.favorited + ", comments=" + this.comments + ", url=" + this.url
                        + ", lastCheck=" + this.lastCheck + ", lastOnline=" + this.lastOnline + "]";
    }

}
