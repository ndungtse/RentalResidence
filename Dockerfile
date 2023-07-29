FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/rentalresidence-0.0.1-SNAPSHOT.jar rentalresidence.jar
EXPOSE 8080
# ENTRYPOINT exec java $JAVA_OPTS -jar rentalresidence.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Dspring.profiles.active=prod -Djava.security.egd=file:/dev/./urandom -jar rentalresidence.jar
