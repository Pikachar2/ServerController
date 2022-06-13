#!/bin/bash
#arkStartup.sh
#script for correctly and safely starting the Ark Survival Evolved 
#Server

# Params
# $1: Session
# $2: Map
# $3: GamePort
# $4: QueryPort
# $5: RCONPort

#if incorrect number of arguments passed
if [ $# -ne 5 ]; then
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

#check if argument is appropriate
if [[ "$3" =~ [^0-9] ]]; then
	echo "INVALID"
	exit 1
fi

#check if argument is appropriate
if [[ "$4" =~ [^0-9] ]]; then
	echo "INVALID"
	exit 1
fi

#check if argument is appropriate
if [[ "$5" =~ [^0-9] ]]; then
	echo "INVALID"
	exit 1
fi

#takes name, imports from that names folder
#importSaveGame
#Need to load files from appropriately saved place
exists=`$ARK_SCRIPT_DIR/arkImportMap.sh $1`
echo $exists
if [ "$exists" -ne 0 ]; then
	echo -e "\e[41m Save does not exist!! \e[0m"
	exit 1;
fi

#retrieve mapName from file from folder
#	mapName=`cat ~/Servers/Ark_Server/ShooterGame/Saved/Config/LinuxServer/mapName.txt`
mapName="$2"
#passes mapName to next script
#Start server
cd $ARK_SERVER_DIR/ShooterGame/Binaries/Linux;
nohup ./server_start.sh "$mapName" "$3" "$4" "$5" &>/dev/null &
echo -e "\e[42m Server Started! \e[0m"
