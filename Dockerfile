FROM maven:3-adoptopenjdk-11 as dependencies

WORKDIR /usr/src/building

COPY pom.xml .

RUN mvn clean package

FROM openjdk:11-slim

WORKDIR /usr/src/app

COPY --from=dependencies /usr/src/building/target/booking.jar .

CMD ["java", "-jar", "booking.jar"]