#!/bin/bash
#arkStatus.sh
#script for finding up/down/loading status of the Ark Survival Evolved 
#Server

# Params
# $1: RCONPort

#if incorrect number of arguments passed
if [ $# -ne 1 ]; then
	echo "Incorrect number of arguments supplied"
	exit 1
fi

#check if argument is appropriate
if [[ "$1" =~ [^0-9] ]]; then
	echo "INVALID"
	exit 1
fi

rconPort=$1

#count people are still on the server
players=$(/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${rconPort} 'ListPlayers')
noPlayers='No Players Connected'
connectFailed='connect() failed.: Connection refused'
cantAuth="Couldn't Authenticate"

echo $players

#if unable to reach server
if [[ "$players" == "$connectFailed" ]] || [[ "$players" == "$cantAuth" ]]; then
	exit -1
else
	exit 1
fi
