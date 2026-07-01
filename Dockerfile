FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean compile

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=builder /build/target/classes /app/classes

ENTRYPOINT ["java", "-cp", "/app/classes", "org.main.Main"]