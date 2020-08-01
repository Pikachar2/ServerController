package com.shockops.controllers;

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
import com.shockops.dto.ArkConfigResponse;
import com.shockops.dto.ArkStatusResponse;
import com.shockops.service.ArkService;

@RestController
@RequestMapping("/ark")
public class ArkController {

    @Autowired
    private ArkService arkService;

    @GetMapping(value = "/start/{sessionName}")
    public TransferInfo startArkServer(@PathVariable(value = "sessionName") String sessionName) {
        return arkService.startArkServer(sessionName);
    }

    @GetMapping(value = "/createmap/{sessionName}/{mapName}")
    public TransferInfo createMapAndStartArkServer(@PathVariable(value = "sessionName") String sessionName,
                    @PathVariable(value = "mapName") String mapName) {
        return arkService.createMapAndStartArkServer(sessionName, mapName);
    }

    @GetMapping(value = "/stop")
    public TransferInfo stopArkServer() {
        return arkService.stopArkServer();
    }

    @GetMapping(value = "/saveAndExport")
    public TransferInfo saveAndExportArkServer() {
        return arkService.saveAndExportArkServer();
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
    public Set<String> getMaps() {
        return arkService.getMaps();
    }

}
