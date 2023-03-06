#!/bin/bash

java -Xmx10g -XX:+UseConcMarkSweepGC -Dserver.port=8888 -XX:TieredStopAtLevel=1 -Duser.timezone=GMT+08 -Dspring.profiles.active=prod -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -XX:InitialCodeCacheSize=128m -XX:ReservedCodeCacheSize=128m -XX:CMSInitiatingOccupancyFraction=72 -XX:+DisableExplicitGC -javaagent:/data/ArmsAgent/arms-bootstrap-1.7.0-SNAPSHOT.jar -Darms.appName=demo-service -jar /data/java-web-demo/target/demo-0.0.1-SNAPSHOT.jar
