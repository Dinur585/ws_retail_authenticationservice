# Build stage
FROM maven:3.6-openjdk-17-slim AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package

# Run stage
FROM openjdk:17-alpine
MAINTAINER Team
COPY --from=build /app/target/ws_retail_authenticationservice-0.0.1-SNAPSHOT.jar ws-retail-authenticationservice.jar
ENTRYPOINT ["java", "-jar","ws-retail-authenticationservice.jar"]

