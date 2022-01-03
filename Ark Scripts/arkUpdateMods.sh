#!/bin/bash
#arkUpdate.sh
#script for correctly and safely updating the Ark Survival Evolved 
#Server

#if server NOT started, update server
if  !(pgrep -x "ShooterGameServ"); then
	steamcmd="~/steamcmd/steamcmd.sh"
	steamModDir="/home/zach/Steam/"
	baseDir="/home/zach/Servers/Ark_Server/"
#	modDir="${steamModDir}steamapps/workshop/extracted/"
	modDir="${baseDir}ShooterGame/Content/Mods/"
	appId="346110"
	#	731604991: Structures plus          
	echo "baseDir: $baseDir"
	echo "modDir: $modDir"

	modArray=(`find "/home/zach/Servers/Ark_Server/ShooterGame/Content/Mods/" -maxdepth 1 -type d -and ! -name '*[!0-9]*' -and ! -name '111111111' | cut -c 56-`)
	#for MOD in 731604991 719928795 764755314 1838617463
#	for MOD in 801082391
	for MOD in ${modArray[*]}
	do
		steamOutput=" "
		while [ true ]; do
			steamOutput=`~/steamcmd/steamcmd.sh +login anonymous +force_install_dir "$steamModDir" +workshop_download_item 346110 $MOD validate +quit`
			echo "steamOutput"
			echo "$steamOutput"
			if [[ "$steamOutput" =~ .*"Downloaded item".* ]]
			then
				break 1;
			else
				echo "Trying again".
			fi
		done
		~/steamcmd/steamcmd.sh +login anonymous +force_install_dir "$steamModDir" +workshop_download_item 346110 $MOD validate +quit
		./extractMod.sh $appId $MOD $modDir

	done
else
	#else, inform that server is already running
	echo -e "\e[41m Server is started!! Shutdown server then update. \e[0m"
fi


