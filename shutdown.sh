#!/bin/bash

function exitIfNonZeroStatus() {
  if [ $? -ne 0 ]; then
    echo -e "${red}$errorMessage${noColor}"
    exit 1
  fi
}

echo "Servers are stopping..."
kill -9 $(cat ./_dist/pid-api-gateway.file) $(cat ./_dist/pid-user-microservice.file)


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
