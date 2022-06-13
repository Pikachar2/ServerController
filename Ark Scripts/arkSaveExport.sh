#!/bin/bash
#arkSaveExport.sh
#script for saving and exporting the save data for Ark Survival Evolved 
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
echo $rconPort

# rcon broadcast message
/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${rconPort} 'broadcast The world is saving now.'

# rcon saveworld
/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${rconPort} 'SaveWorld'

sleep 10;
/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${rconPort} 'broadcast Map Saved!'
echo -e "\e[42m Map Saved! \e[0m"
exit

