# hsbc-assessment

This project consists two part of server, first server is called '**api-gateway**', second server is called '**user-microservice**'


### How to run Application?
##### Environment
1. Java version 15
2. Apache Maven version 3

#### Run Server

Set permissions to execute scripts:
```  
$ chmod u+x build.sh startup.sh shutdown.sh
```
Firstly, we should build '**api-gateway**' and '**user-microservice**' completely under '**_disk**' folder using build script as follows:
```  
$ ./build.sh   
```
Run server with this script
```  
$ ./startup.sh
```
Stop server with this script
```  
$ ./shutdown.sh
```
You can check swagger api below link.
##### API url: http://localhost:8080/swagger-ui.html

### Which technologies I used

1. spring-boot
2. spring-mvc
2. spring-data
3. hibernate
4. Junit-test
5. springfox-swagger
6. spring-cloud-starter-netflix-zuul
7. h2 database

