@echo off

set "nacos_path=E:\Code\idea_space\nacos\bin"
set "command_name=startup.cmd"

start "nacos" cmd /c "cd /d %nacos_path% & call %command_name% -m standalone"