#!/bin/bash

function exitIfNonZeroStatus() {
  if [ $? -ne 0 ]; then
    echo -e "${red}$errorMessage${noColor}"
    exit 1
  fi
}

echo "Servers are stopping..."
api_gateway_pid_file="_dist/pid-api-gateway.file"
user_micro_service_pid_file="_dist/pid-user-microservice.file"

#Logs
api_gateway_log_file="_dist/api-gateway.log"
user_micro_service_log_file="_dist/user-microservice.log"

kill -9 $(cat $api_gateway_pid_file) $(cat $user_micro_service_pid_file)

if [ -f "$api_gateway_pid_file" ] ; then
    rm "$api_gateway_pid_file"
fi

if [ -f "$user_micro_service_pid_file" ] ; then
    rm "$user_micro_service_pid_file"
fi

if [ -f "$api_gateway_log_file" ] ; then
    rm "$api_gateway_log_file"
fi

if [ -f "$user_micro_service_log_file" ] ; then
    rm "$user_micro_service_log_file"
fi
