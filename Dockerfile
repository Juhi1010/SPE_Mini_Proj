# Use OpenJDK 17
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/*.jar app.jar

# Set the entry point to execute the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

#CMD ["sh", "-c", "while true; do sleep 3600; done"]