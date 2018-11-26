#!/bin/sh

while ! `nc -z $CONFIGSERVER_HOST $CONFIGSERVER_PORT`; do 
    echo "********************************************************"
    echo "Waiting for the configuration server to start on port 8888"
    echo "********************************************************"
    sleep 4; 
done

echo "Config Server $CONFIGSERVER_HOST up and running at $CONFIGSERVER_PORT"

while ! `nc -z $BOOKSERVER_HOST $BOOKSERVER_PORT`; do 
    echo "********************************************************"
    echo "Waiting for the book server to start on port 8081"
    echo "********************************************************"
    sleep 4; 
done

echo "book server $BOOKSERVER_HOST up and running at $BOOKSERVER_PORT"


java -Djava.security.egd=file:/dev/./urandom -Dspring.cloud.config.uri=$GUTENBERG_CONFIG_URI -Dspring.profiles.active=$PROFILE -jar /app.jar

