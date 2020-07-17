package com.shockops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shockops.beans.ArkData;
import com.shockops.beans.ArkScript;
import com.shockops.beans.TransferInfo;

@Service
public class ArkService extends ServerService {

    @Autowired
    private IPAddressService ipAddressService;

    public TransferInfo getServerStatus() {
        // TODO need to check arkServers to see if arkserver is actually up and
        // running.
        /*
         * This needs to have it's own controller, not really a script to run, but needs to access
         * an api?
         */
        // TODO Link for help on getting server info
        // https://ark-servers.net/help/api/

        // Acquire current IPAddress
        ipAddressService.getMyIp();

        ArkData data = dataTrawler.exchangeAndConvert();

        if ((data == null) || data.equals(null)) {
            return new TransferInfo("Offline");
        }
        // TODO check the data to see if the server is in fact up and running

        return new TransferInfo("Online");
    }

    public TransferInfo updateArkServer() {
        ArkScript script = new ArkScript();
        TransferInfo retval = new TransferInfo(scriptRunner.updateServer(script));

        return retval;
    }

    public TransferInfo stopArkServer() {
        ArkScript script = new ArkScript();
        TransferInfo retval = new TransferInfo(scriptRunner.stopServer(script));

        return retval;
    }

    public TransferInfo createMapAndStartArkServer(String sessionName, String mapName) {
        ArkScript script = new ArkScript();
        TransferInfo retval = new TransferInfo(scriptRunner.createMapAndStartServer(script, sessionName, mapName));

        return retval;
    }

    public TransferInfo startArkServer(String sessionName) {
        ArkScript script = new ArkScript();
        TransferInfo retval = new TransferInfo(scriptRunner.startServer(script, sessionName));

        return retval;
    }

}
