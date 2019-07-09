# seleniumIPR

mvn io.qameta.allure:allure-maven:serve  to   run allure report

java -jar jenkins.war to run jenins

free needed port:
netstat -an | find /i "listening"      |     list of all listening ports\n
netstat -ano | findstr :4444           |     find a certain listening port\n
taskkill/PID 1140/F                    |     kill the port by its ID ^\n


setup Selenium Grid:
java - jar "C:/path/to/jar" - role hub 
This starts a hub using default parameter values

check it: http://localhost:4444/grid/console

OPEN ANOTHER COMMAND PROMT
java -jar "C:/path/to/jar" -role node -hub http://localhost:4444/grid/register

refresh grid console
voila

