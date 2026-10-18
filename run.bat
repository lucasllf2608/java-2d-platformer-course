@echo off
cd /d "%~dp0"
if not exist bin\graficos\Game.class call compile.bat
if errorlevel 1 exit /b 1
java -p bin -m JogoDoCurso/graficos.Game
