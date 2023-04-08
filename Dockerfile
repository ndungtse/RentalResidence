# Use the official maven image as the base image
FROM maven:3.9.1-jdk-17-slim AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml .

# Download and install the dependencies
RUN mvn dependency:go-offline -B

# Copy the application source code to the container
COPY src ./src

# Build the application
RUN mvn package

# Use the official OpenJDK image as the base image
FROM adoptopenjdk/openjdk17:alpine-jre

# Set the working directory
WORKDIR /app

# Copy the built JAR file to the container
COPY --from=build /app/target/rentalresidence-0.0.1-SNAPSHOT.jar .

# Run the application
CMD ["java", "-jar", "rentalresidence-0.0.1-SNAPSHOT.jar"]
