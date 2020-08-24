#!/bin/bash
#arkSaveExport.sh
#script for saving and exporting the save data for Ark Survival Evolved 
#Server

admin_pass='trains'
host='127.0.0.1'
port=27020

# rcon broadcast message
/usr/bin/rcon -P${admin_pass} -a${host} -p${port} 'broadcast The world is saving now.'

# rcon saveworld
/usr/bin/rcon -P${admin_pass} -a${host} -p${port} 'SaveWorld'

#if server started, stop server
if  (pgrep -x "ShooterGameServ"); then
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
	~/Scripts/ArkScripts/arkExportMapForSave.sh "$sessionName"

	# rcon broadcast message
	/usr/bin/rcon -P${admin_pass} -a${host} -p${port} 'broadcast The current world has been saved and exported to' + $sessionName + '.'

	exit
else
	#else, inform that server is not running
	echo -e "\e[41m Server is not started \e[0m"
	# rcon broadcast message
	/usr/bin/rcon -P${admin_pass} -a${host} -p${port} 'broadcast Something went wrong. Game not exported.'

	exit -1
fi


