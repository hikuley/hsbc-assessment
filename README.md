# hsbc-assessment

This project consists two part of server, first server is called '**api-gateway**', second server is called '**user-microservice**'


**api-gateway** runs on 8080 port, **user-microservice** runs on 8090 port, and all the integration tests and unit test are ready under test package


### How to run Application?
##### Environment
1. Java version 15
2. Apache Maven version 3

#### Build Server

Set permissions to execute scripts:
```  
$ chmod u+x build.sh startup.sh shutdown.sh
```
Firstly, we should build '**api-gateway**' and '**user-microservice**' completely under '**_disk**' folder using build script as follows:
```  
$ ./build.sh   
```
during compile and packaging all integration tests and unit tests pass and then the script move all jars to _dict folder.

#### Run Server
Run server with this script
```  
$ ./startup.sh
```
Stop server with this script
```  
$ ./shutdown.sh
```
You can check swagger api below link.
##### API url: http://localhost:8090/swagger-ui.html

#### API URLs
Create one user record
```
curl -X POST 'http://localhost:8080/user-api/user/create' -H 'Content-Type: application/json' --data-raw '{ "firstName":"test" }'
```
Read all users
```
curl -X GET 'http://localhost:8080/user-api/user/read' -H 'Content-Type: application/json'
```


### Which technologies I used

1. spring-boot
2. spring-mvc
2. spring-data
3. hibernate
4. Junit-test
5. springfox-swagger
6. spring-cloud-starter-netflix-zuul
7. h2 database

