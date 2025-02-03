# Use official Java runtime as a base image
FROM openjdk:23-jdk-slim
VOLUME /tmp
ADD  target/*.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
EXPOSE 8080:8080


