# Utiliza una imagen base de OpenJDK 21
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Maven desde tu máquina local al contenedor
COPY target/pragma-aws-services-0.0.1-SNAPSHOT.jar /app/pragma-aws-services.jar

# Expone el puerto en el que la aplicación se ejecutará (por defecto 8080 en Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "/app/pragma-aws-services.jar"]
