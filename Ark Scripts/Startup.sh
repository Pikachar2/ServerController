#!/bin/bash
#arkStartup.sh
#script for correctly and safely starting the Ark Survival Evolved 
#Server
#$1: saveName
#$2: saveDir


#if incorrect number of arguments passed
if [ $# -ne 1 ]; then
	echo "No arguments supplied"
	exit 1
fi

#takes name, imports from that names folder
	#importSaveGame
	#Need to load files from appropriately saved place
	exists=`~/Scripts/ArkScripts/ImportMap.sh $1 $2`
	if [ "$exists" -ne 0 ]; then
		echo -e "\e[41m Save does not exist!! \e[0m"
		exit 1;
	fi
	#retrieve mapName from file from folder
	mapName=`cat ~/Servers/Ark_Server/ShooterGame/Saved/Config/LinuxServer/mapName.txt`
	#passes mapName to next script
	#Start server
	cd ~/Servers/Ark_Server/ShooterGame/Binaries/Linux;
	nohup ./server_start.sh "$mapName" &>/dev/null &
	echo -e "\e[42m Server Started! \e[0m"

