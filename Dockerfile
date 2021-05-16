FROM openjdk:8
EXPOSE 9090
ADD target/spring-jenkins-docker-app-0.0.1-SNAPSHOT.jar spring-jenkins-docker-app.jar
ENTRYPOINT ["java","-jar","spring-jenkins-docker-app.jar"]
