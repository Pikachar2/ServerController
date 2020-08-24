#!/bin/bash
#arkStartup.sh
#script for correctly and safely starting the Ark Survival Evolved 
#Server

#if incorrect number of arguments passed
if [ $# -ne 2 ]; then
	echo "Incorrect number of arguments supplied"
	exit 1
fi

#check if argument is appropriate
if [[ "$1" =~ [^a-zA-Z0-9-_] ]]; then
	echo "INVALID"
	exit 1
fi

#check if argument is appropriate
if [[ "$2" =~ [^a-zA-Z0-9-_] ]]; then
	echo "INVALID"
	exit 1
fi


#if server NOT started, start server
if  !(pgrep -x "ShooterGameServ"); then

#takes name, imports from that names folder
	#importSaveGame
	#Need to load files from appropriately saved place
	exists=`~/Scripts/ArkScripts/arkImportMap.sh $1`
	if [ "$exists" -ne 0 ]; then
		echo -e "\e[41m Save does not exist!! \e[0m"
		exit 1;
	fi
	#retrieve mapName from file from folder
#	mapName=`cat ~/Servers/Ark_Server/ShooterGame/Saved/Config/LinuxServer/mapName.txt`
	mapName="$2"
	#passes mapName to next script
	#Start server
	cd ~/Servers/Ark_Server/ShooterGame/Binaries/Linux;
	nohup ./server_start.sh "$mapName" &>/dev/null &
	echo -e "\e[42m Server Started! \e[0m"
else
	#else, inform that server is already running
	echo -e "\e[41m Server already started!! \e[0m"
fi


