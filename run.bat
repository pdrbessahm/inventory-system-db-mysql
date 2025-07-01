@echo off
setlocal

echo =================================
echo Compilando os arquivos Java...
echo =================================
javac -cp "lib\mysql-connector-j-9.3.0.jar" -d bin src\*.java

echo.
echo =================================
echo Executando o sistema...
echo =================================
"C:\Program Files\Java\jdk-21\bin\java.exe" -cp "bin;lib\mysql-connector-j-9.3.0.jar" App

pause