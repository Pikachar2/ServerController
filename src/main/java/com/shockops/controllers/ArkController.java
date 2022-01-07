package com.shockops.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shockops.beans.ArkSession;
import com.shockops.beans.TransferInfo;
import com.shockops.config.EnvironmentProperties;
import com.shockops.dto.ArkConfigResponse;
import com.shockops.dto.ArkStatusResponse;
import com.shockops.service.ArkService;

@RestController
@RequestMapping("/ark")
public class ArkController {

    @Autowired
    private ArkService arkService;

    @GetMapping(value = "/start/{sessionName}/{mapName}")
    public TransferInfo startArkServer(@PathVariable(value = "sessionName") String sessionName,
                    @PathVariable(value = "mapName") String mapName) {
        return arkService.startArkServer(sessionName, mapName);
    }

    @GetMapping(value = "/createmap/{sessionName}/{mapName}")
    public TransferInfo createMapAndStartArkServer(@PathVariable(value = "sessionName") String sessionName,
                    @PathVariable(value = "mapName") String mapName) {
        return arkService.createMapAndStartArkServer(sessionName, mapName);
    }

    @GetMapping(value = "/stop/{mapName}")
    public TransferInfo stopArkServer(@PathVariable(value = "mapName") String mapName) {
        return arkService.stopArkServer(mapName);
    }

    @GetMapping(value = "/saveAndExport/{mapName}")
    public TransferInfo saveAndExportArkServer(@PathVariable(value = "mapName") String mapName) {
        return arkService.saveAndExportArkServer(mapName);
    }

    @GetMapping(value = "/update")
    public TransferInfo updateArkServer() {
        return arkService.updateArkServer();
    }

    @GetMapping(value = "/status")
    public ArkStatusResponse getStatus() {
        return arkService.getServerStatus();
    }

    @GetMapping("/sessions")
    public Set<ArkSession> getSessions() {
        return arkService.getSessions();
    }

    @GetMapping("/config/{sessionName}/{configFileName}")
    public ArkConfigResponse getConfig(@PathVariable(value = "sessionName") String sessionName,
                    @PathVariable(value = "configFileName") String configFileName) {
        return arkService.getConfig(sessionName, configFileName);
    }

    @PostMapping("/config/{sessionName}/{configFileName}")
    public String saveConfig(@RequestBody String configData, @PathVariable(value = "sessionName") String sessionName,
                    @PathVariable(value = "configFileName") String configFileName) {
        return arkService.saveConfig(sessionName, configData, configFileName);
    }

    @GetMapping("/maps")
    public List<String> getMaps() {
        return arkService.getMaps();
    }

    @GetMapping("/kick/{playerId}")
    public TransferInfo kickPlayer(@PathVariable(value = "playerId") String playerId) {
        return arkService.kickPlayer(playerId);
    }

    @GetMapping("/maxMapsRunning")
    public Integer getMaxMapsRunning() {
        return EnvironmentProperties.MAX_MAPS_RUNNING;
    }

}
