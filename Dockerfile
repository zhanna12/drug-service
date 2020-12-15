FROM openjdk:8
ADD target/drug-service.jar drug-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "drug-service.jar"]