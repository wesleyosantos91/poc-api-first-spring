FROM java:8
ADD target/api-first-*.jar.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]