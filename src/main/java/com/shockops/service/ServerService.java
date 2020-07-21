package com.shockops.service;

import javax.inject.Inject;

import com.shockops.beans.ScriptInfo;

public class ServerService {

    @Inject
    protected DataTrawler dataTrawler;
    @Inject
    protected ScriptRunner scriptRunner;
    @Inject
    protected ScriptInfo scriptInfo;

}
