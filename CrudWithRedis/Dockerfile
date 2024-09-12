FROM eclipse-temurin:21-jdk

RUN apt-get update && apt-get install -y redis-server

WORKDIR /app

COPY ./target/*.jar ./redistry.jar

RUN ls -l


CMD ["sh", "-c", "redis-server & java -jar redistry.jar"]
