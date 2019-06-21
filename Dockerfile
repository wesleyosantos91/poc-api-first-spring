FROM openjdk:8-jdk-alpine
ADD target/api-first-*.jar.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]