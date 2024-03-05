# Utilizar la imagen base oficial de Java (JDK) para ejecutar aplicaciones Spring Boot
FROM openjdk:17-jdk

# Argumento para pasar el JAR_FILE al construir la imagen
ARG JAR_FILE=target/*.jar

# Copiar el archivo JAR de tu aplicación al contenedor
COPY ${JAR_FILE} app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]
