@echo off
if not exist bin mkdir bin
javac -d bin -sourcepath src src\module-info.java src\graficos\Game.java
if errorlevel 1 exit /b 1
echo Compilacao OK.
