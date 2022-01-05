#! /bin/bash

# Start UI
sudo sh $CATALINA_HOME/bin/startup.sh


#Start Controller
java -jar "/home/zach/Web/servercontroller-test.jar"

