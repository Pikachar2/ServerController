#!/bin/bash
#arkImportMap.sh
#script for correctly and safely importing Ark saved data 

#if incorrect number of arguments passed
if [ $# -ne 1 ]; then
	echo "No arguments supplied"
	exit 1
fi

#check if argument is appropriate
if [[ "$1" =~ [^a-zA-Z0-9-_] ]]; then
	echo "INVALID"
	exit 1
fi

#if server currently running
if  (pgrep -x "ShooterGameServ"); then
	#else, inform that server is currently running
	echo -e "\e[41m Server running, cant setup!! \e[0m"
else

	baseDir="/home/zach/Servers/Ark_Server/ShooterGame"
	saveDir="$baseDir/SavedMaps/$1"
	if [ ! -d "$saveDir" ]; then
		#directory does not exist
		echo -e "\e[41m Save does not exist!! \e[0m"
		exit 1; #
	fi

	#restore maps
	cd "$baseDir"

	#remove old data
	if [ ! -d "$baseDir/Saved" ]; then
		rm Saved
	fi
	if [ ! -d "$baseDir/Content/Mods" ]; then
		rm Content/Mods
	fi

	#load maps
	ln -s "$saveDir"/Mods "Content/Mods"
	ln -s "$saveDir"/Saved "Saved"

	echo -e "\e[42m Map loaded! \e[0m"
	exit 0; #not sure if this is needed
fi

