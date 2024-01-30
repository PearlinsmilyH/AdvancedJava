# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory to /app
WORKDIR /app

# Copy the application JAR into the container at /app
COPY build/libs/Crud_Operation-0.0.1-SNAPSHOT.jar /app/crudapp.jar

# Specify the command to run on container startup
CMD ["java", "-jar", "crudapp.jar"]