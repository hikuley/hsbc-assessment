#!/bin/bash

errorMessage="Something went wrong, terminating script."
#Color codes
red='\033[0;31m'
green='\033[0;32m'
noColor='\033[0m'

#Exit on non-zero status
function exitIfNonZeroStatus() {
  if [ $? -ne 0 ]; then
    echo -e "${red}$errorMessage${noColor}"
    exit 1
  fi
}

echo "GIT: Updating repository"
git pull origin master

exitIfNonZeroStatus

echo "Creating 'dist' folder"
if [ -d _dist ]; then
  echo "dir already present"
else
  echo "dir is not present"
  mkdir _dist
fi

exitIfNonZeroStatus

cd user-microservice/

exitIfNonZeroStatus

echo "Packaging user-microservice"
mvn -v
mvn clean

exitIfNonZeroStatus

mvn -o package

exitIfNonZeroStatus

echo "Copying JARSs to _dist dir."
cp ./target/user-microservice-0.0.1-SNAPSHOT.jar ../_dist/

exitIfNonZeroStatus

cd ../api-gateway

exitIfNonZeroStatus

echo "Packaging api-gateway"
mvn -v
mvn clean

exitIfNonZeroStatus

mvn -o package

exitIfNonZeroStatus

echo "Copying JARSs to _dist dir."
cp ./target/api-gateway-0.0.1-SNAPSHOT.jar ../_dist/
