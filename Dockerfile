FROM eclipse-temurin:21-jdk as build
WORKDIR /app

RUN apt update && apt install -y maven && rm -rf /var/lib/apt/lists/*

COPY pom.xml .
#Downloads and cache dependencies
RUN mvn dependency:go-offline -B

#Builds Jar file
COPY src ./src
RUN mvn clean package

#Builds final container
FROM eclipse-temurin:21-jre

WORKDIR /app

#netcat checks if database is running
RUN apt update && apt install -y netcat-openbsd && rm -rf /var/lib/apt/lists/*

COPY --from=build /app/target/app-for-learning-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["sh", "-c", "until nc -z db 5432; do echo waiting for db; sleep 1; done; java -jar app.jar"]
