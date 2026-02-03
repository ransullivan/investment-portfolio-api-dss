# Base image
FROM eclipse-temurin:25-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar hasil build ke container
COPY build/libs/investment-portfolio-0.0.1-SNAPSHOT.jar app.jar

# Expose port aplikasi
EXPOSE 8080

# Run aplikasi
ENTRYPOINT ["java","-jar","app.jar"]
