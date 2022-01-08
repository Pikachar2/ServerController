#!/bin/bash
#arkCreateMap.sh
#script for correctly and safely creating a game 

# Params
# $1: SessionName
# $2: MapName

#if incorrect number of arguments passed
if [ $# -ne 1 ]; then
	echo "No arguments supplied"
	exit 1
fi

#check if sessionName is appropriate
if [[ "$1" =~ [^a-zA-Z0-9-_] ]]; then
	echo "INVALID"
	exit 1
fi

#if server currently running
if  (pgrep -x "ShooterGameServ"); then
	#else, inform that server is currently running
	echo -e "\e[41m Server running, cant create map!! \e[0m"
else
	#Add session to GameUserSettings.ini
	sessionName="SessionName=$1"
	templateHome="$ARK_SCRIPT_DIR/Template"
	newHome="$ARK_SAVED_MAPS_DIR/$1"
	GUSiniNew="$newHome/Saved/Config/LinuxServer/GameUserSettings.ini"


#	cp -r "$templateHome/Mods" "$newHome/Mods"
	cp -r "$templateHome/Saved" "$newHome/Saved"

	#add sessionName to GameUserSettings.ini
	echo "$sessionName" >> "$GUSiniNew"

	echo -e "\e[42m Session Created! \e[0m"
	exit 0; #not sure if this is needed
fi


