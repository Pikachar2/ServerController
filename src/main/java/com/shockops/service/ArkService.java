package com.shockops.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import com.shockops.common.StatusLock;
import com.shockops.config.EnvironmentProperties;
import com.shockops.dto.ArkConfigResponse;
import com.shockops.dto.ArkStatusResponse;
import com.shockops.enums.StatusEnum;

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

    @Autowired
    EnvironmentProperties propertyConfiguration;

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
        Boolean isFullyOnline;
        if ((data == null) || data.equals(null)) {
            isFullyOnline = false;
        } else {
            isFullyOnline = true;
        }
        // TODO check the data to see if the server is in fact up and running
        // return new ArkStatusResponse("Offline");

        // return new ArkStatusResponse("Online");
        return new ArkStatusResponse(correlateStatus(isFullyOnline));
    }

    private String correlateStatus(Boolean isFullyOnline) {
        StatusEnum statEnum = StatusLock.getStatusEnum();

        switch (statEnum) {
            case STARTING_SCRIPT:
            case SPINNING_UP:
            case CREATING:
            case CREATED:
                if (!isFullyOnline) {
                    return StatusLock.getStatusMsg();
                }
                StatusLock.setStatusEnum(StatusEnum.STARTED, StatusLock.getSessionName(), StatusLock.getMapName());
                break;
            case STARTED:
                if (!isFullyOnline) {
                    StatusLock.setStatusEnum(StatusEnum.OFFLINE);
                }
                break;
            case OFFLINE:
                if (isFullyOnline) {
                    StatusLock.setStatusEnum(StatusEnum.STARTED, "UNKNOWN", "UNKNOWN");
                }
                break;
            default:
        }

        return StatusLock.getStatusMsg();
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

    public TransferInfo startArkServer(String sessionName, String mapName) {
        ArkScript script = new ArkScript();
        TransferInfo retval = new TransferInfo(scriptRunner.startServer(script, sessionName, mapName));
        return retval;
    }

    public Set<ArkSession> getSessions() {
        Set<ArkSession> arkSessions = new HashSet<>();

        // get list of sessions
        // NOTE: Test local on "C:\\"
        // Set<String> sessions = commandLineService.listDirectoriesUsingJavaIO("C:\\");
        Set<String> sessions = commandLineService.listDirectoriesUsingJavaIO(EnvironmentProperties.ARK_SAVED_MAPS_DIR);

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
            String sessionSaveDir = EnvironmentProperties.ARK_SAVED_MAPS_DIR + "/" + session + "/Saved/SavedArks";
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
        String configSaveDir =
                        EnvironmentProperties.ARK_SAVED_MAPS_DIR + "/" + sessionName + "/Saved/Config/LinuxServer/";
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
        String configSaveDir =
                        EnvironmentProperties.ARK_SAVED_MAPS_DIR + "/" + sessionName + "/Saved/Config/LinuxServer/";

        // check if status allowed
        if (StatusLock.isRunning()) {
            return StatusLock.getStatusMsg();
        }

        StatusLock.setStatusEnum(StatusEnum.CONFIG_SAVING);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configSaveDir + configFileName + ".ini"))) {
            writer.write(configData);
        } catch (IOException ex) {
            ex.printStackTrace();
            StatusLock.setStatusEnum(StatusEnum.OFFLINE);
        }
        StatusLock.setStatusEnum(StatusEnum.OFFLINE);
        return "Config Saved!";
    }

    public List<String> getMaps() {
        List<String> maps = new ArrayList<>();
        try {
            // List<String> allLines =
            // Files.readAllLines(Paths.get("C:\\Users\\highi\\Desktop\\MapNames.txt"));
            List<String> allLines = Files.readAllLines(Paths.get(EnvironmentProperties.ARK_MAP_FILE));
            maps.addAll(allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maps;
    }
}
