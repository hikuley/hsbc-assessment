#!/bin/bash

function exitIfNonZeroStatus() {
  if [ $? -ne 0 ]; then
    echo -e "${red}$errorMessage${noColor}"
    exit 1
  fi
}

echo "api-gateway is stopping..."
kill $(cat ./_dist/pid-api-gateway.file)
exitIfNonZeroStatus


echo "api-gateway is stopping..."
kill $(cat ./_dist/pid-user-microservice.file)
exitIfNonZeroStatus