FROM openjdk:17
ADD target/DevopsAPI-0.0.1-SNAPSHOT.jar DevopsAPI-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","DevopsAPI-0.0.1-SNAPSHOT.jar"]
