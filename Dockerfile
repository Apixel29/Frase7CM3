FROM eclipse-temurin:25-jdk-alpine
LABEL authors="Hector Octavio Gonzalez Marquez"
ARG JAR_FILE=target/Frases-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_frase.jar
EXPOSE 8084


ENTRYPOINT ["java", "-jar", "app_frase.jar"]