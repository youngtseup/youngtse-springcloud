#!/bin/bash

nacos_path=/Users/5veda/Documents/youngtse/idea_space/nacos/bin
nacos_command=startup.sh

osascript -e "tell application \"Terminal\" to activate"
osascript -e "tell application \"System Events\" to tell process \"Terminal\" to keystroke \"t\" using command down"
osascript -e "tell application \"Terminal\" to do script \"cd ${nacos_path} && ./${nacos_command} -m standalone\" in selected tab of the front window"

osascript -e "tell application \"System Events\" to tell process \"Terminal\" to keystroke \"t\" using command down"
redis_command=redis-server
osascript -e "tell application \"Terminal\" to do script \"${redis_command}\" in selected tab of the front window"
