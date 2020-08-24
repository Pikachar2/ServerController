#!/bin/bash
#arkStop.sh
#script for correctly and safely stopping the Ark Survival Evolved 
#Server

admin_pass='trains'
host='127.0.0.1'
port=27020

# rcon broadcast message
/usr/bin/rcon -P${admin_pass} -a${host} -p${port} 'broadcast This server is going offline in 15 seconds, the world is saving now, any changes made beyond this point will be lost.'

# rcon saveworld
/usr/bin/rcon -P${admin_pass} -a${host} -p${port} 'SaveWorld'

# wait 15s
sleep 15;

#if people are still on the server
players=$(/usr/bin/rcon -P${admin_pass} -a${host} -p${port} 'ListPlayers')
noPlayers='No Players Connected'

echo $players

#if nobody is online
#if [[ $players == *"No Players Connected"* ]]; then
#if [[ $players == *"No Players Connected"* ]]; then
	#if server started, stop server
	if  (pgrep -x "ShooterGameServ"); then
		pkill -KILL ShooterGameServ;
		echo -e "\e[42m Server is now stopped. \e[0m"
		# wait 10s for server to finish terminating
		sleep 10;

		#retrieve sessionName from GameUserSettings.ini
		inFile="/home/zach/Servers/Ark_Server/ShooterGame/Saved/Config/LinuxServer/GameUserSettings.ini"
		while read -r line
		do
			if [[ $line == "SessionName="* ]]; then
				pair=$(echo $line | tr "=" "\n")
				for value in $pair
				do
					    sessionName="$value"
				done
				#stuff 12
				break;
			fi
		done < "$inFile"
		#backup files to appropriately saved place
		~/Scripts/ArkScripts/arkExportMap.sh "$sessionName"
		exit
	else
		#else, inform that server is not running
		echo -e "\e[41m Server is not started \e[0m"
		exit -1
	fi
#else
	#else, inform that players are still online
#	echo -e "\e[41m Players are still online \e[0m"
#	exit -1
#fi


