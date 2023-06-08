@echo off

set "redis_path=D:\Tools\Redis"
set "file_name=redis-server.exe"

start "redis" cmd /c "cd /d %redis_path% & %file_name%"