@echo off

set "nacos_path=E:\Code\idea_space\nacos\bin"
set "command_name=shutdown.cmd"

cd /d %nacos_path%
call %command_name%

taskkill /F /IM redis-server.exe