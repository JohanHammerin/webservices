FROM openjdk:21-jdk-slim

# Sätt att gruppera våra filer
WORKDIR /app

COPY build/libs/lektion-5-0.0.1-SNAPSHOT.jar /app/lektion-5.jar

# Måste vara samma port som Spring använder
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/lektion-5.jar"]
