FROM openjdk:8
EXPOSE 8080
ADD target/eventdemo-0.0.1-SNAPSHOT.jar eventdemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","target/eventdemo-0.0.1-SNAPSHOT.jar"]