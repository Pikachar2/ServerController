package com.shockops.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shockops.beans.ArkData;
import com.shockops.beans.BaseScript;
import com.shockops.beans.ScriptInfo;
import com.shockops.common.ConstVars;

@Service
public class ScriptRunner extends Thread {

    @Autowired
    private ScriptInfo scriptInfo;
    private BaseScript bScript;

    public String startServer(BaseScript script, String sessionName) {
        this.bScript = script;

        if (scriptInfo.isRunning()) {
            if (scriptInfo.getStatus().equals(ConstVars.SERVERUPDATING)) {
                return ConstVars.UPDATING;
            } else if (new DataTrawler().exchangeAndConvert() == null) {
                return ConstVars.STARTING;
            }
            return ConstVars.PREVIOUSINSTANCE;
        }

        String retval = runBasicScript(script.getStartScript(), ConstVars.STARTING, true, ConstVars.SERVERRUNNING,
                        sessionName);

        return retval;
    }

    public String createMapAndStartServer(BaseScript script, String sessionName, String mapName) {
        this.bScript = script;

        if (scriptInfo.isRunning()) {
            if (scriptInfo.getStatus().equals(ConstVars.SERVERUPDATING)) {
                return ConstVars.UPDATING;
            } else if (new DataTrawler().exchangeAndConvert() == null) {
                return ConstVars.STARTING;
            }
            return ConstVars.PREVIOUSINSTANCE;
        }

        String retval = runBasicScript(script.getCreateScript(), ConstVars.STARTING, true, ConstVars.SERVERRUNNING,
                        sessionName, mapName);

        return retval;
    }

    public String stopServer(BaseScript script) {
        if (!scriptInfo.isRunning()) {
            return ConstVars.NOINSTANCE;
        }

        // TODO check if people are in the game
        String retval = runBasicScript(script.getStopScript(), ConstVars.STOPPED, false, ConstVars.EMPTY);

        return retval;
    }

    public String saveAndExportServer(BaseScript script) {
        if (!scriptInfo.isRunning()) {
            return ConstVars.NOINSTANCE;
        }

        String retval = runBasicScript(script.getSaveScript(), ConstVars.SAVED, true, ConstVars.SERVERRUNNING);

        return retval;
    }

    public String updateServer(BaseScript script) {
        this.bScript = script;

        if (scriptInfo.isRunning()) {
            if (scriptInfo.getStatus().equals(ConstVars.SERVERUPDATING)) {
                return ConstVars.UPDATING;
            }
            return ConstVars.GAMERUNNING;
        }

        String retval = runBasicScript(script.getUpdateScript(), ConstVars.UPDATED, true, ConstVars.SERVERUPDATING);

        return retval;
    }

    public String runBasicScript(String scriptFunction, String successString, Boolean isRunning, String status,
                    String... args) {
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
        pb.directory(new File(ConstVars.SCRIPTDIR));
        pb.inheritIO();
        // start process
        try {
            System.out.println("Executing: " + pb.command());
            scriptInfo.setArkServer(pb.start());
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
                stopServer(bScript);
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
