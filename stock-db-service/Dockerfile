FROM openjdk:8
ADD target/docker-stock-db-service.jar docker-stock-db-service.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","docker-stock-db-service.jar"]