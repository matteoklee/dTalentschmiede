# Start with the base image for Java 17
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/dTalentschmiede-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that Spring Boot runs on
EXPOSE 8085

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
