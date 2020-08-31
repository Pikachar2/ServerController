#!/bin/bash
#arkStop.sh
#script for correctly and safely stopping the Ark Survival Evolved 
#Server

# rcon broadcast message
/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${RCON_PORT} 'broadcast This server is going offline in 15 seconds, the world is saving now, any changes made beyond this point will be lost.'

# rcon saveworld
/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${RCON_PORT} 'SaveWorld'

# wait 15s
sleep 15;

#if people are still on the server
players=$(/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${RCON_PORT} 'ListPlayers')
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

