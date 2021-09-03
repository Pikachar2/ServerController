#!/bin/bash
#arkUpdate.sh
#script for correctly and safely updating the Ark Survival Evolved 
#Server

#if server NOT started, update server
if  !(pgrep -x "ShooterGameServ"); then
	~/steamcmd/steamcmd.sh +login anonymous +force_install_dir "/home/zach/Servers/Ark_Server" +app_update 376030 validate +quit;
	echo -e "\e[42m Application Update is finished! \e[0m"
	echo -e "\e[42m Updating mods... \e[0m"
	./arkUpdateMods.sh
	echo -e "\e[42m Update is finished! \e[0m"
else
	#else, inform that server is already running
	echo -e "\e[41m Server is started!! Shutdown server then update. \e[0m"
fi


