#!/bin/bash
#arkExportMap.sh
#script for correctly and safely exporting Ark saved data 

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
	echo -e "\e[41m Server running, cant backup!! \e[0m"
else
#NEED to move appropriate server to main dir then execute
#also need to update scripts accordingly

	baseDir="/home/zach/Servers/Ark_Server/ShooterGame/SavedMaps"
	saveDir="$baseDir/$1"
	if [ ! -d "$saveDir" ]; then
		# Control will enter here if $DIRECTORY doesn't exist.
		cd $baseDir
		mkdir $saveDir
	fi
	#backup maps
	cd ~/Servers/Ark_Server/ShooterGame;
	cp -r Content/Mods SavedMaps/"$1"
	cp -r Saved SavedMaps/"$1"
	echo -e "\e[42m Map Saved! \e[0m"
	exit 0; #not sure if this is needed
fi


