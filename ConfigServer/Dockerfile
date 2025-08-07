FROM openjdk:21

WORKDIR /app

COPY target/config_docker_app.jar config_docker_app.jar

EXPOSE 8094

ENTRYPOINT ["java","-jar","config_docker_app.jar"]