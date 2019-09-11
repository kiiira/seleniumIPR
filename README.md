## seleniumIPR

**to run jenkins:**
```
java -jar jenkins.war 
```

**free needed port:**
```
netstat -an | find /i "listening"       list of all listening ports
netstat -ano | findstr :4444            find a certain listening port
taskkill/PID 1140/F                     kill the port by its ID ^
```


**setup Selenium Grid:**
```
java - jar "C:/path/to/jar" - role hub 
```
This starts a hub using default parameter values

check it: http://localhost:4444/grid/console

OPEN ANOTHER COMMAND PROMPT and set up two nodes
```
java -jar "C:/path/to/jar" -role node -hub http://localhost:4444/grid/register
```

refresh grid console and
*voilà*

