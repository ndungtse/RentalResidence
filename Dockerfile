#
# dockerizing springboot application with jdk 17 and maven
#

# pull base image
FROM maven:3.8.1-jdk-17
COPY . .
RUN ./mvnw clean package

# Package stage
FROM openjdk:17-jdk-alpine
COPY --from=build ./target/rentalresidence-0.0.1-SNAPSHOT.jar rentalresidence.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "rentalresidence.jar", "--server.port=8080", "--spring.profiles.active=prod", "--spring.config.location=classpath:/application-prod.yml"]
