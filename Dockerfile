# Stage 1: Build the application
FROM gradle:9-jdk17-alpine AS build
WORKDIR /app/
EXPOSE 8080
COPY build/libs/testSpring-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]


