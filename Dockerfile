#
# Build stage
#
FROM maven:3.8.2-jdk-17 AS build
COPY . .
RUN ./mvnw clean package -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/rentalresidence-0.0.1-SNAPSHOT.jar rentalresidence.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","rentalresidence.jar"]