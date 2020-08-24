#!/bin/bash
#arkCreateMap.sh
#script for correctly and safely creating a game 
#PARAMS: sessionName=$1, mapName=$2,

#if incorrect number of arguments passed
if [ $# -ne 2 ]; then
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
	templateHome="/home/zach/Scripts/ArkScripts/Template"
	newHome="/home/zach/Servers/Ark_Server/ShooterGame"
	GUSiniNew="/home/zach/Servers/Ark_Server/ShooterGame/Saved/Config/LinuxServer/GameUserSettings.ini"

	#remove old data
	cd "$newHome"
	rm -rf Saved
	rm -rf Content/Mods

	cp -r "$templateHome/Mods" "$newHome/Content"
	cp -r "$templateHome/Saved" "$newHome"

	#add sessionName to GameUserSettings.ini
	echo "$sessionName" >> "$GUSiniNew"
	#Add appropriate settings to GameUserSettings.ini
		#done via template/manual editing

	#create mapName.txt
	mapNameFile="/home/zach/Servers/Ark_Server/ShooterGame/Saved/Config/LinuxServer/mapName.txt"
	echo "$2" > "$mapNameFile"
	#Start game
	#Start server
	cd ~/Servers/Ark_Server/ShooterGame/Binaries/Linux;
	nohup ./server_start.sh "$2" &>/dev/null &
	echo -e "\e[42m Server Started! \e[0m"

	#create save folder
	baseDir="/home/zach/Servers/Ark_Server/ShooterGame"
	saveDir="$baseDir/SavedMaps/$1"
	if [ ! -d "$saveDir" ]; then
		#directory does not exist
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


