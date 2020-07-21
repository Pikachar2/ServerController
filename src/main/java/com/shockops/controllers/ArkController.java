package com.shockops.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shockops.beans.TransferInfo;
import com.shockops.service.ArkService;

@RestController
@RequestMapping("/ark")
public class ArkController extends ServerController {

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
    public TransferInfo getStatus() {
        return arkService.getServerStatus();
    }

}
