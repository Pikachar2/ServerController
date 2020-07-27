package com.shockops.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shockops.beans.ArkData;
import com.shockops.beans.ArkScript;
import com.shockops.beans.ArkSession;
import com.shockops.beans.ScriptInfo;
import com.shockops.beans.TransferInfo;
import com.shockops.common.ConstVars;
import com.shockops.dto.ArkConfigResponse;
import com.shockops.dto.ArkStatusResponse;

@Service
public class ArkService {

    @Autowired
    protected DataTrawler dataTrawler;
    @Autowired
    protected ScriptRunner scriptRunner;
    @Autowired
    protected ScriptInfo scriptInfo;

    @Autowired
    private IPAddressService ipAddressService;

    @Autowired
    private CommandLineService commandLineService;

    public ArkStatusResponse getServerStatus() {
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
            return new ArkStatusResponse("Offline");
        }
        // TODO check the data to see if the server is in fact up and running

        return new ArkStatusResponse("Online");
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

    public TransferInfo saveAndExportArkServer() {
        ArkScript script = new ArkScript();
        TransferInfo retval = new TransferInfo(scriptRunner.saveAndExportServer(script));

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

    public Set<ArkSession> getSessions() {
        Set<ArkSession> arkSessions = new HashSet<>();

        // get list of sessions
        // NOTE: Test local on "C:\\"
        // Set<String> sessions = commandLineService.listDirectoriesUsingJavaIO("C:\\");
        Set<String> sessions = commandLineService.listDirectoriesUsingJavaIO(ConstVars.ARK_SAVED_MAPS_DIR);

        // File filter
        Predicate<? super File> filter = (file -> {
            Boolean isNotDir = !file.isDirectory();
            String fileName = file.getName();
            Boolean hasArkExtension = FilenameUtils.isExtension(fileName, "ark");
            Boolean isNotDateName = !fileName.matches(ConstVars.ARK_DATE_FILENAME_REGEX);
            return isNotDir && hasArkExtension && isNotDateName;
        });

        // Retrieve map names for each session
        for (String session : sessions) {
            // NOTE: Test local on SavedArks Folder
            String sessionSaveDir = ConstVars.ARK_SAVED_MAPS_DIR + "/" + session + "/Saved/SavedArks";
            // String sessionSaveDir =
            // "F:\\Program
            // Files\\SteamLibrary\\steamapps\\common\\ARK\\ShooterGame\\Saved\\SavedArks";
            Set<String> mapList = commandLineService.listFilesUsingJavaIOWithFilter(sessionSaveDir, filter);

            // Drop the file extension
            mapList = mapList.stream().map(s -> s.endsWith(".ark") ? s.substring(0, s.length() - 4) : s)
                            .collect(Collectors.toSet());

            ArkSession arkSession = new ArkSession(session, mapList);
            arkSessions.add(arkSession);
        }

        return arkSessions;
    }

    public ArkConfigResponse getConfig(String sessionName, String configFileName) {
        // String configSaveDir =
        // "F:\\Program
        // Files\\SteamLibrary\\steamapps\\common\\ARK\\ShooterGame\\Saved\\Config\\WindowsServer\\";
        String configSaveDir = ConstVars.ARK_SAVED_MAPS_DIR + "/" + sessionName + "/Saved/Config/LinuxServer/";
        String configData = "";
        // configFileName += ".ini";

        try (FileInputStream fis = new FileInputStream(configSaveDir + configFileName + ".ini")) {
            configData = IOUtils.toString(fis, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new ArkConfigResponse(configData);
    }

    public String saveConfig(String sessionName, String configData, String configFileName) {
        // String configSaveDir =
        // "F:\\Program
        // Files\\SteamLibrary\\steamapps\\common\\ARK\\ShooterGame\\Saved\\Config\\WindowsServer\\";
        String configSaveDir = ConstVars.ARK_SAVED_MAPS_DIR + "/" + sessionName + "/Saved/Config/LinuxServer/";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configSaveDir + configFileName + ".ini"))) {
            writer.write(configData);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "Config Saved!";
    }
}
