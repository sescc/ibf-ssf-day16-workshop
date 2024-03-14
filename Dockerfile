FROM maven:3-eclipse-temurin-21 AS builder

LABEL MAINTAINER="wsc@ibf.ssf"
LABEL APPLICATION="SSF Day 16 Workshop"

ARG APP_DIR=/app

# Dir to contain src and target
WORKDIR ${APP_DIR}

# Copy all required files into the app folder in the image
COPY  mvnw.cmd .
COPY  mvnw .
COPY  pom.xml .
COPY  .mvn .mvn
COPY  src src

# Run Maven command to build package, exclude unit testing
# DL Maven dependencies and build jar file into target folder
RUN mvn package -Dmaven.test.skip=true

ENV PORT=8080

EXPOSE ${PORT}

ENTRYPOINT SERVER_PORT=${PORT} java -jar target/day16-workshop-0.0.1-SNAPSHOT.jar
# target/<name in pom>-<version>.jar