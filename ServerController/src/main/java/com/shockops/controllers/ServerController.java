package com.shockops.controllers;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RestController;

import com.shockops.beans.ScriptInfo;
import com.shockops.service.DataTrawler;
import com.shockops.service.ScriptRunner;

@RestController
public class ServerController {

    @Inject
    protected DataTrawler dataTrawler;
    @Inject
    protected ScriptRunner scriptRunner;
    @Inject
    protected ScriptInfo scriptInfo;

    // @RequestMapping(value = "/**/running", method = RequestMethod.GET, produces =
    // "application/json")
    // public String isRunning(){
    // String retval = Boolean.valueOf(scriptInfo.isRunning()).toString();
    //
    // return retval;
    // }
}
