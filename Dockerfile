FROM openjdk:8-jre-slim
COPY ./target/*.jar /tmp/app.jar
WORKDIR /tmp/
EXPOSE 8084
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]