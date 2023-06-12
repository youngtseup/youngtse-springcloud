@echo off

set "nacos_path=E:\Code\idea_space\nacos\bin"
set "command_name=startup.cmd"
start "nacos" /min cmd /c "cd /d %nacos_path% & call %command_name% -m standalone"

set "redis_path=D:\Tools\Redis"
set "file_name=redis-server.exe"
start "redis" /min cmd /c "cd /d %redis_path% & %file_name%"