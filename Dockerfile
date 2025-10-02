FROM eclipse-temurin:21-jdk as build
WORKDIR /app

RUN apt update && apt install -y maven && rm -rf /var/lib/apt/lists/*

#Downloads and cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

#Builds Jar file
COPY src ./src
RUN mvn clean package

#Copies bilded Jar file
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/app-for-learning-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
