FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/microservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dserver.port=$PORT","-jar","/app.jar"]
