#!/bin/bash
#arkKickPlayer.sh
#script for kicking a player for Ark Survival Evolved 
#Server

# Params
# $1: PlayerId
# $2: RCONPort

rconPort=$2
echo $rconPort


kick_command='KickPlayer '$1
SUCCESS_CHECK_STRING='Kicked';

SUCCESS_STRING='Player kicked from the server.';
ERROR_STRING='Player NOT kicked.';

# rcon kick Player
OUTPUT=$(/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${rconPort} ${kick_command})
echo "${OUTPUT}"

if [[ "$OUTPUT" == *"$SUCCESS_CHECK_STRING"* ]]; then
	OUTPUT_STRING=$SUCCESS_CHECK_STRING
else
	OUTPUT_STRING=$ERROR_STRING
fi

# rcon broadcast message
/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${rconPort} 'broadcast '$OUTPUT_STRING

exit

