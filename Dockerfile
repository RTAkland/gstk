FROM openjdk:21-jdk-slim

WORKDIR /app

RUN chmod +x gradlew && ./gradlew build

COPY build/libs/gstk-all.jar /app/gstk-all.jar

COPY data.db /app/data.db

ENTRYPOINT ["java", "-jar", "gstk-all.jar"]

EXPOSE 8080