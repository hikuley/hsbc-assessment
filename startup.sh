#!/bin/bash

function exitIfNonZeroStatus() {
  if [ $? -ne 0 ]; then
    echo -e "${red}$errorMessage${noColor}"
    exit 1
  fi
}

api_gateway_pid_file="_dist/pid-api-gateway.file"
if [ -f "$api_gateway_pid_file" ] ; then
    rm "$api_gateway_pid_file"
fi

user_micro_service_pid_file="_dist/pid-user-microservice.file"
if [ -f "$user_micro_service_pid_file" ] ; then
    rm "$user_micro_service_pid_file"
fi

api_gateway_log_file="_dist/api-gateway.log"
if [ -f "$api_gateway_log_file" ] ; then
    rm "$api_gateway_log_file"
fi

user_micro_service_log_file="_dist/user-microservice.log"
if [ -f "$user_micro_service_log_file" ] ; then
    rm "$user_micro_service_log_file"
fi

echo "api-gateway is starting..."
nohup java -jar ./_dist/api-gateway-0.0.1-SNAPSHOT.jar > $api_gateway_log_file 2>&1 &
echo $! > $api_gateway_pid_file

exitIfNonZeroStatus

echo "user-microservice is starting..."
nohup java -jar ./_dist/user-microservice-0.0.1-SNAPSHOT.jar > $user_micro_service_log_file 2>&1 &
echo $! > $user_micro_service_pid_file

exitIfNonZeroStatus
