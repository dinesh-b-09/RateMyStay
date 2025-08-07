FROM openjdk:21

WORKDIR /app

COPY target/user_docker_app.jar user_docker_app.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","user_docker_app.jar"]