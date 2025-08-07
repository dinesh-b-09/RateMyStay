FROM openjdk:21

WORKDIR /app

COPY target/auth_docker_app.jar auth_docker_app.jar

EXPOSE 8095

ENTRYPOINT ["java","-jar","auth_docker_app.jar"]