#!/bin/bash
redis_pid=`ps -ef | grep redis-server | grep -v grep| awk '{print $2}'`
nacos_path=/Users/5veda/Documents/youngtse/idea_space/nacos/bin
nacos_command=shutdown.sh

osascript -e "tell application \"Terminal\" to activate"
osascript -e "tell application \"Terminal\" to do script \"kill -9 ${redis_pid} && cd ${nacos_path} && ./${nacos_command}\""
