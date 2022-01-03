#!/bin/bash
#arkSaveExport.sh
#script for saving and exporting the save data for Ark Survival Evolved 
#Server

# rcon broadcast message
/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${RCON_PORT} 'broadcast The world is saving now.'

# rcon saveworld
/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${RCON_PORT} 'SaveWorld'

sleep 10;
/usr/bin/rcon -P${ARK_ADMIN_PASS} -a${RCON_HOST} -p${RCON_PORT} 'broadcast Map Saved!'
echo -e "\e[42m Map Saved! \e[0m"
exit

