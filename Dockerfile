FROM maven:3-adoptopenjdk-11 as dependencies

WORKDIR /usr/src/building

COPY . .

RUN mvn clean package

FROM openjdk:11-slim

WORKDIR /usr/src/app

COPY --from=dependencies /usr/src/building/target/app.jar .

CMD ["java", "-jar", "app.jar"]