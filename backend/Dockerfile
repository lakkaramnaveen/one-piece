# 1️⃣ Use Java 17 (safe default for Spring Boot)
FROM eclipse-temurin:17-jdk-alpine

# 2️⃣ Create app directory inside container
WORKDIR /app

# 3️⃣ Copy Maven build output (jar) into container
COPY target/*.jar app.jar

# 4️⃣ Expose backend port (Spring Boot default)
EXPOSE 8080

# 5️⃣ Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
