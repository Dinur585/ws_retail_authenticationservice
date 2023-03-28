FROM openjdk:17-jdk-alpine
MAINTAINER Team
COPY target/ws_retail_authenticationservice-0.0.1-SNAPSHOT.jar ws-retail-authenticationservice.jar
ENTRYPOINT ["java", "-jar","ws-retail-authenticationservice.jar"]

#EXPOSE 8007