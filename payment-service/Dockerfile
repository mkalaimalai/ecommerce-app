#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

#Information around who maintains the image
MAINTAINER mkalaimalai

# Add the application's jar to the image
COPY target/payment-service-0.0.1-SNAPSHOT.jar payment-service0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "payment-service-0.0.1-SNAPSHOT.jar"]