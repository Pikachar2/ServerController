package com.shockops.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shockops.beans.ArkData;
import com.shockops.beans.BaseScript;
import com.shockops.beans.ScriptInfo;
import com.shockops.common.ConstVars;
import com.shockops.common.StatusLock;
import com.shockops.config.EnvironmentProperties;
import com.shockops.enums.StatusEnum;
import com.shockops.types.MultiArgFunction;
import com.shockops.util.StatusMapUtil;

@Service
public class ScriptRunner extends Thread {

    @Autowired
    EnvironmentProperties propertyConfiguration;

    @Autowired
    private ScriptInfo scriptInfo;
    private BaseScript bScript;

    public String startServer(BaseScript script, String sessionName, String mapName) {
        this.bScript = script;

        if (StatusLock.isRunning()) {
            return StatusLock.getStatusMsg();
        }

        StatusLock.setStatusEnum(StatusEnum.STARTING_SCRIPT, sessionName, mapName);
        String retval = runBasicScript(script.getStartScript(), ConstVars.STARTING, true, ConstVars.SERVER_RUNNING,
                        StatusMapUtil::statusCheckAndUpdateStarted, sessionName, mapName);

        return retval;
    }

    public String createMapAndStartServer(BaseScript script, String sessionName, String mapName) {
        this.bScript = script;

        if (StatusLock.isRunning()) {
            return StatusLock.getStatusMsg();
        }

        StatusLock.setStatusEnum(StatusEnum.CREATING, sessionName, mapName);
        String retval = runBasicScript(script.getCreateScript(), ConstVars.STARTING, true, ConstVars.SERVER_RUNNING,
                        StatusMapUtil::statusCheckAndUpdateCreated, sessionName, mapName);

        return retval;
    }

    public String stopServer(BaseScript script, String mapName) {
        if (!StatusLock.isRunning()) {
            return StatusLock.getStatusMsg();
        }

        StatusLock.setStatusEnum(StatusEnum.STOPPING, mapName);
        // TODO check if people are in the game
        String retval = runBasicScript(script.getStopScript(), ConstVars.STOPPED, false, ConstVars.EMPTY,
                        StatusMapUtil::statusCheckAndUpdateStopped, mapName);

        return retval;
    }

    public String saveAndExportServer(BaseScript script, String mapName) {
        // TODO: MAPNAME STUFFS
        if (!StatusLock.isRunning()) {
            return StatusLock.getStatusMsg();
        }

        StatusLock.setStatusEnum(StatusEnum.SAVING, StatusLock.getSessionName(), StatusLock.getMapNames());
        String retval = runBasicScript(script.getSaveScript(), ConstVars.SAVED, true, ConstVars.SERVER_RUNNING,
                        StatusMapUtil::statusCheckAndUpdateSaved, mapName);

        return retval;
    }

    public String updateServer(BaseScript script) {
        this.bScript = script;

        if (StatusLock.isRunning()) {
            return StatusLock.getStatusMsg();
        }

        StatusLock.setStatusEnum(StatusEnum.UPDATING);
        String retval = runBasicScript(script.getUpdateScript(), ConstVars.UPDATED, true, ConstVars.SERVER_UPDATING,
                        StatusMapUtil::statusCheckAndUpdateUpdatedServer);

        return retval;
    }

    public String kickPlayer(BaseScript script, String playerId) {
        if (!StatusLock.isRunning()) {
            return StatusLock.getStatusMsg();
        }

        String retval = runBasicScript(script.getKickScript(), ConstVars.KICKED, true, ConstVars.SERVER_RUNNING,
                        StatusMapUtil::statusCheckAndUpdateKicked, playerId);
        return retval;
    }

    @SuppressWarnings("resource")
    public String runBasicScript(String scriptFunction, String successString, Boolean isRunning, String status,
                    MultiArgFunction<String> statusMethod, String... args) {
        // NOTE: READ OUTPUT ASYNC
        // https://stackoverflow.com/questions/30725175/java-read-process-output-when-its-finished
        String retval = successString;
        List<String> processBuilderArgsList = new ArrayList<>();
        processBuilderArgsList.add(scriptFunction);
        processBuilderArgsList.addAll(Arrays.asList(args));

        // ProcessBuilder pb = new ProcessBuilder("myshellScript.sh", "myArg1",
        // "myArg2");
        // create builder
        ProcessBuilder pb =
                        new ProcessBuilder(processBuilderArgsList.toArray(new String[processBuilderArgsList.size()]));

        // set running directory
        pb.directory(new File(EnvironmentProperties.SCRIPT_DIR));
        // pb.inheritIO();
        // start process
        try {
            System.out.println("Executing: " + pb.command());
            Process core = pb.start();
            InputStream stream = core.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            new Thread(() -> {
                try {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                        statusMethod.apply(line, args);
                    }
                } catch (IOException ex) {
                    // TODO: stub out
                }
            }).start();

            scriptInfo.setArkServer(core);
            setStatus(isRunning, status);
        } catch (IOException e) {
            System.out.println("something broke");
            e.printStackTrace();
            retval = ConstVars.FAIL;
        }

        System.out.println("just before returning...");
        // new StatusThread(script).start();
        return retval;
    }

    private void setStatus(boolean isRunning, String status) {
        scriptInfo.setRunning(isRunning);
        scriptInfo.setStatus(status);
    }

    // Thread stuff
    @Override
    public void run() {
        DataTrawler dt = new DataTrawler();
        ArkData data = dt.exchangeAndConvert();

        while (true) {
            data = dt.exchangeAndConvert();
            try {
                sleep(300000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if ((data == null) || data.equals(null)) {
                // server is offline
                break;
            } else if ((data.getPlayers().size() == 0) || (data.getInfo().getPlayers().length() == 0)) {
                // if nobody is online
                // turn off server
                System.out.println("is this even used????? ScriptRunner");
                stopServer(bScript, null);
                // leave loop/join thread
                break;
            }

        }
        try {
            this.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
