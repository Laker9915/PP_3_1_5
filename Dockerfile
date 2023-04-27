FROM openjdk:17-jdk-alpine
ADD /target/SpringSecurityApp-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java","-jar","backend.jar"]