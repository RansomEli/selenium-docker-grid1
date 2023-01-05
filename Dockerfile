# FROM openjdk:8u212-jre-alpine3.9
FROM amazoncorretto:8u312-alpine3.13-jre
RUN apk add curl jq

# Workspace
WORKDIR /usr/share/udemy

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar			selenium-docker.jar
ADD target/selenium-docker-tests.jar	selenium-docker-tests.jar
ADD target/libs 						libs

# in case of any other dependencies like .csv, .json, .xlsx
#  please ADD that as well
#
#   To add test files, use the following statement (mvn does not package test resources by default)
# ADD src/test/resouces                 src/test/resources


# ADD suite files
ADD book-flight-module.xml				book-flight-module.xml
ADD search-aaca.xml					    search-aaca.xml

# ADD health check script
ADD healthcheck.sh                      healthcheck.sh

# We are expecting 3 input variables:
#  BROWSER
#  HUB_HOST
#  MODULE

#ENTRYPOINT java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" 
#            -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $search-module
# 
ENTRYPOINT sh healthcheck.sh
#ENTRYPOINT java -cp "selenium-docker.jar:selenium-docker-tests.jar:libs/*" -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE