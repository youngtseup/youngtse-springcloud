@echo off

set "redis_path=D:\Tools\Redis"
set "file_name=redis-cli.exe"

start "redis-cli" cmd /c "cd /d %redis_path% & %file_name%"