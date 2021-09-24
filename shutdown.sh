#!/bin/bash

function exitIfNonZeroStatus() {
  if [ $? -ne 0 ]; then
    echo -e "${red}$errorMessage${noColor}"
    exit 1
  fi
}

echo "Servers are stopping..."
kill -9 $(cat ./_dist/pid-api-gateway.file) $(cat ./_dist/pid-user-microservice.file)