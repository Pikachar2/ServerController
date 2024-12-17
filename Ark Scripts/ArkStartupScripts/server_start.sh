#! /bin/bash
#./ShooterGameServer TheIsland?listen?SessionName=APPIANSUCKS?#ServerPassword=appian?ServerAdminPassword=trains -NoBattlEye -server -#log

#! /bin/bash
pwd
echo mapNameend: "$1"
#./ShooterGameServer MapName="$1"?listen -NoBattlEye -server -log -activeevent=Summer
#./ShooterGameServer "$1"?listen -NoBattlEye -server -log -activeevent=Summer
#./ShooterGameServer "$1"?listen -NoBattlEye -server -log -ActiveEvent=FearEvolved


#./ShooterGameServer "$1"?listen?Port=7777?QueryPort=27015?RCONEnabled=True?RCONPort=27020 -NoTransferFromFiltering -clusterid=bacon007 -NoBattlEye -server -log -activeevent=Summer
#./ShooterGameServer "$1"?listen?Port="$2"?QueryPort="$3"?RCONEnabled=True?RCONPort="$4" -NoTransferFromFiltering -clusterid=bacon007 -NoBattlEye -server -log -activeevent=Summer
./ShooterGameServer "$1"?listen?Port="$2"?QueryPort="$3"?RCONEnabled=True?RCONPort="$4" -NoTransferFromFiltering -clusterid=bacon007 -NoBattlEye -server -log
#--- The Below command, breaks up each map. This should solve the save deletion issue, but will require obelisk for transport.
#./ShooterGameServer "$1"?listen?Port="$2"?QueryPort="$3"?RCONEnabled=True?RCONPort="$4"?AltSaveDirectoryName="$1" -NoTransferFromFiltering -clusterid=bacon007 -NoBattlEye -server -log


#rcon -Ptrains -a127.0.0.1 -p27020 listplayers



