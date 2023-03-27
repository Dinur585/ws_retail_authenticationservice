FROM openjdk:8-jdk-alpine
MAINTAINER Team
COPY target/ws-retail-authenticationservice.jar ws-retail-authenticationservice.jar
ENTRYPOINT ["java", "-jar","ws-retail-authenticationservice.jar"]

#EXPOSE 8007