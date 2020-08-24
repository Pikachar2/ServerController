#!/bin/bash
#arkImportMap.sh
#script for correctly and safely importing Ark saved data 
#$1: saveName
#$2: saveDir

#if incorrect number of arguments passed
if [ $# -ne 2 ]; then
	echo "Wrong Number of arguments supplied"
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
	saveDir="$2/$1"
	if [ ! -d "$saveDir" ]; then
		#directory does not exist
		echo -e "\e[41m Save does not exist!! \e[0m"
		exit 1; #
	fi

	#restore maps
	cd "$baseDir"
	#remove old data
	rm -rf Saved
	rm -rf Content/Mods

	#restore maps
	cp -r "$saveDir"/Mods "$baseDir/Content"
	cp -r "$saveDir"/Saved "$baseDir"
	echo -e "\e[42m Map loaded! \e[0m"
	exit 0; #not sure if this is needed
fi


