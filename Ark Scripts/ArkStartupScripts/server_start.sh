#! /bin/bash
#./ShooterGameServer TheIsland?listen?SessionName=APPIANSUCKS?#ServerPassword=appian?ServerAdminPassword=trains -NoBattlEye -server -#log

#! /bin/bash
pwd
echo mapNameend: "$1"
#./ShooterGameServer MapName="$1"?listen -NoBattlEye -server -log -activeevent=Summer
./ShooterGameServer "$1"?listen -NoBattlEye -server -log -activeevent=Summer
#./ShooterGameServer "$1"?listen -NoBattlEye -server -log -ActiveEvent=FearEvolved

#rcon -Ptrains -a127.0.0.1 -p27020 listplayers




