# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Add maintainer info
LABEL maintainer="egabi-user-management"

# Create a directory for the application
WORKDIR /app

# Copy the JAR file from target directory to the container
COPY target/usermanagement.jar app.jar

# Expose the port that the application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]