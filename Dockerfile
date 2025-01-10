FROM openjdk:17-jre-slim

RUN ./gradlew bootJar

ARG JAR_FILE=build/libs/FeatureToggle-1.0.0.jar

COPY ${JAR_FILE} app.jar

CMD ["java", "-jar", "/app.jar"]