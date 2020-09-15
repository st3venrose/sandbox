FROM maven:3.6.3-openjdk-11-slim AS build
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src src
RUN mvn package -Dmaven.test.skip=true -P docker
RUN mvn resources:resources liquibase:update

FROM openjdk:11-slim
COPY --from=build /usr/src/app/target/*.jar /usr/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/usr/app/app.jar"]