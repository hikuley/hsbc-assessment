#!/bin/bash

function exitIfNonZeroStatus() {
  if [ $? -ne 0 ]; then
    echo -e "${red}$errorMessage${noColor}"
    exit 1
  fi
}

echo "api-gateway is starting..."
nohup java -jar ./_dist/api-gateway-0.0.1-SNAPSHOT.jar > ./_dist/api-gateway.log 2>&1 &
echo $! > ./_dist/pid-api-gateway.file

exitIfNonZeroStatus

echo "user-microservice is starting..."
nohup java -jar ./_dist/user-microservice-0.0.1-SNAPSHOT.jar > ./_dist/user-microservice.log 2>&1 &
echo $! > ./_dist/pid-user-microservice.file

exitIfNonZeroStatus
