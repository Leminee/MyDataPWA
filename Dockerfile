FROM openjdk:latest
ADD target/pwa.jar pwa.jar
ENTRYPOINT ["java", "-jar","/pwa.jar"]